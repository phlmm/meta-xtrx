# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=860e4083ceb93ce0939b1a58fcaacb53"

SRC_URI = "git://github.com/jgaeddert/liquid-dsp;protocol=https;branch=master"

# Modify these as desired
PV = "1.7.0+git"
SRCREV = "7133af0e2f54997814ca9af5522d98f8d23b5bdf"
DEPENDS += "fftw"

# NOTE: unable to map the following CMake package dependencies: SIMD fftw3f
inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DFIND_SIMD=OFF -DBUILD_EXAMPLES=OFF -DBUILD_AUTOTESTS=OFF -DBUILD_BENCHMARKS=OFF"

