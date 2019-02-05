public class fence {

    static String make(String eini) {
        StringBuilder sb = new StringBuilder();
        sb.append(eini);
        for (int i = 0; i < ((3 - (eini.length() % 3)) % 3); i++) {
            sb.append('$');
        }
        String klartext = sb.toString();

        StringBuilder ersteZeile = new StringBuilder();
        for (int i = 0; i < klartext.length(); i++) {
            if (i % 4 == 0) {
                ersteZeile.append(klartext.charAt(i));
            } else {
                ersteZeile.append('$');
            }
        }

        StringBuilder mittlereZeile = new StringBuilder();
        for (int i = 0; i < klartext.length(); i++) {
            if (i % 2 == 1) {
                mittlereZeile.append(klartext.charAt(i));
            } else {
                mittlereZeile.append('$');
            }
        }

        StringBuilder dritteZeile = new StringBuilder();
        for (int i = 0; i < klartext.length(); i++) {
            if (i % 4 == 2) {
                dritteZeile.append(klartext.charAt(i));
            } else {
                dritteZeile.append('$');
            }
        }
        System.out.println(ersteZeile.toString());
        System.out.println(mittlereZeile.toString());
        System.out.println(dritteZeile.toString());
        StringBuilder zsammen = new StringBuilder();
        zsammen.append(ersteZeile).append(mittlereZeile).append(dritteZeile);
        StringBuilder aussi = new StringBuilder();
        for (int i = 0; i < zsammen.length(); i++) {
            if (zsammen.charAt(i) != '$') {
                aussi.append(zsammen.charAt(i));
            }
        }
        return aussi.toString();

    }

    static String decode(String eini) {
        StringBuilder sb = new StringBuilder();
        sb.append(eini);
        for (int i = 0; i < ((3 - (eini.length() % 3)) % 3); i++) {
            sb.append(' ');
        }
        String schlüsseltext = sb.toString();
        StringBuilder aussi = new StringBuilder();
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < schlüsseltext.length(); i++) {

            if (i % 4 == 0) {
                aussi.append(schlüsseltext.charAt(x));
                x++;
            }

            if (i % 2 == 1) {
                aussi.append(schlüsseltext.charAt((eini.length() + 3) / 4 + y));
                y++;
            }

            if (i % 4 == 2) {
                aussi.append(schlüsseltext.charAt(
                        eini.length()
                       - ((eini.length()+1)/4)
                        + z));
                z++;
            }
        }
        return aussi.toString();
    }
}
