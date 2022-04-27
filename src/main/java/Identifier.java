public class Identifier {

    private Boolean validaIdentificador=false;

    public Boolean validaIdentificador(String identificador) {

        validaIdentificador = validaTamanhoDoIdentificador(identificador);
        validaIdentificador = validaSePrimeiroCaractereEUmaLetra(identificador);
        validaIdentificador = validaSeIdentificadorContemSomenteCaracteresValidos(identificador);

        return validaIdentificador;
    }

    private Boolean validaTamanhoDoIdentificador(String identificador) {
        if (identificador.length() < 1 || identificador.length() > 6) {
            throw new IllegalArgumentException(
                    "Tamanho de identificador inválido");
        } else return true;
    }

    private Boolean validaSePrimeiroCaractereEUmaLetra(String identificador) {
        String primeiroCaractere = identificador.substring(0, 1);

        if (primeiroCaractere.matches("[A-Z]*") || primeiroCaractere.matches("[a-z]*")) {
            return true;
        } else {
            throw new IllegalArgumentException("Identificador inválido. Primeiro caractere deve ser uma letra");
        }
    }

    private Boolean validaSeIdentificadorContemSomenteCaracteresValidos(String identificador) {

        for (int i = 0; i < identificador.length(); i++) {
            if (((identificador.charAt(i) >= 'A') && (identificador.charAt(i) <= 'Z')) || ((identificador.charAt(i) >= 'a') && (identificador.charAt(i) <= 'z')) || ((identificador.charAt(i) >= '0') && (identificador.charAt(i) <= '9'))) {
                continue;
            } else {
                throw new IllegalArgumentException("Identificador inválido. Identificador possui caracteres diferentes de letras e números");
            }
        }
        return true;
    }
}
