FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
DEPENDS:remove = "feh"
RDEPENDS:${PN}:remove = "feh"
do_install:append() {
    bbnote "Manually installing missing code and fec sub-libraries skipped by CMake..."

    # Ensure the target library directory exists
    install -d ${D}${libdir}

    cp -P ${B}/lib/libgnuradio-satellites.so* ${D}${libdir}/
}
