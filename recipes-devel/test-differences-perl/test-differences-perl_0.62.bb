DESCRIPTION = "When the code you're testing returns multiple lines, records or data \
structures and they're just plain wrong, an equivalent to the Unix \
\"diff\" \
utility may be just what's needed. Here's output from an example test \
script \
that checks two text documents and then two (trivial) data structures:"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Test-Differences"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
    file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SRC_URI = "http://cpan.metacpan.org/authors/id/D/DC/DCANTRELL/Test-Differences-0.62.tar.gz"

SRC_URI[md5sum] = "3aa6f4d0c3550d50bfa71a80c28aabd3"
SRC_URI[sha256sum] = "b627194ca3cc3de282a46417e894239bc3ac3a814732af76112dc7cdfcf05075"
RDEPENDS_${PN} += "capture-tiny-perl"
RDEPENDS_${PN} += "text-diff-perl"

S = "${WORKDIR}/Test-Differences-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
