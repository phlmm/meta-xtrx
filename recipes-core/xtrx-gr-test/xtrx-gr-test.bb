LICENSE = "CLOSED"
SRC_URI += "file://xtrx_gr_test.py"
RDEPENDS:${PN} += "python3 gnuradio soapysdr python3-pyyaml"
S = "${UNPACKDIR}"
do_install() {
    install -m 0755 -D ${S}/xtrx_gr_test.py ${D}/${bindir}/xtrx_gr_test
}
FILES:${PN} += "/usr/bin/*"
