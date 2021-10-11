refs:
https://trac.pjsip.org/repos/wiki/Getting-Started/Autoconf#Requirements
https://blog.yasking.org/a/ubuntu-install-pjsip-pjsua2.html
https://www.pjsip.org/pjsua.htm

prepare:
curl -L -# -o openh264.tar.gz https://github.com.cnpmjs.org/cisco/openh264/archive/openh264v2.1.0.tar.gz
tar xvf openh264.tar.gz
cd openh264-openh264v2.1.0/
make
sudo make install

git clone https://github.com/lemenkov/libyuv.git
cd libyuv
mkdir build
cd build 
cmake -DCMAKE_BUILD_TYPE="Release" ..
cmake --build . --target install --config Release

sudo apt install git build-essential nasm libsdl2-dev libv4l-dev swig default-jre default-jdk python3-dev
sudo add-apt-repository ppa:wireshark-dev/stable
sudo apt update
sudo apt install wireshark

build scripts:
./configure --enable-shared CFLAGS="-O0 -g" --with-openh264=/usr/local
make dep
make
sudo make install
sudo /sbin/ldconfig
cd pjsip-apps/src/swig/
make
sudo make install
cd pjsip-apps/src/swig/python
sudo python3 setup.py install

pjlib/include/pj/config_site.h:
#include <pj/config_site_sample.h>
#define PJMEDIA_HAS_VIDEO 1
#define PJMEDIA_HAS_OPENH264_CODEC 1
#define PJMEDIA_VIDEO_DEV_HAS_SDL 1
#define PJMEDIA_VIDEO_DEV_HAS_V4L2 1

launch.json:
{
    "name": "(gdb) 启动",
    "type": "cppdbg",
    "request": "launch",
    "program": "/home/alex/programs/pjproject/pjsip-apps/bin/pjsua-x86_64-unknown-linux-gnu",
    "args": [
        "--id", "sip:43000000801320008064@106.13.40.177:5061",
        "--registrar", "sip:106.13.40.177:5061",
        "--realm", "\\*",
        "--username", "43000000801320008064",
        "--password", "123456"
    ],
    "stopAtEntry": true,
    "cwd": "${fileDirname}",
    "environment": [],
    "externalConsole": false,
    "MIMode": "gdb",
    "setupCommands": [
        {
            "description": "为 gdb 启用整齐打印",
            "text": "-enable-pretty-printing",
            "ignoreFailures": true
        }
    ]
}