# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/kit-cel/gr-radar.git;protocol=https;branch=master"

# Modify these as desired
PV = "1.0+git"
SRCREV = "820c0ce6697dc85cccf46bbfabe8b0504dc67578"
DEPENDS += "uhd python3-pyqt5 doxygen qwt-qt5"
# NOTE: unable to map the following CMake package dependencies: Doxygen Qwt UHD Qt5Widgets FFTW3f Gnuradio
inherit gnuradio-oot

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

