./configure --disable-libyuv CFLAGS="-O0 -g"
make dep
make

pjlib/include/pj/config_site.h:
#include <pj/config_site_sample.h>
#define PJMEDIA_HAS_VIDEO 1
#define PJMEDIA_HAS_OPENH264_CODEC 1
#define PJMEDIA_VIDEO_DEV_HAS_SDL 1
#define PJMEDIA_VIDEO_DEV_HAS_V4L2 1