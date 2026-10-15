package com.example.aulajovem20262ia.utils;

public class CpfUtils {

    /**
     * Valida um CPF (com ou sem máscara).
     *
     * @param cpf String contendo o CPF
     * @return true se o CPF for válido, false caso contrário
     */
    public static boolean isValidCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            return false;
        }

        String cleanCpf = OnlyNumber.onlyNumber(cpf);

        if (cleanCpf.length() != 11) {
            return false;
        }

        if (cleanCpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(cleanCpf.charAt(i)) * (10 - i);
            }
            int firstDigit = 11 - (sum % 11);
            if (firstDigit > 9) {
                firstDigit = 0;
            }

            if (firstDigit != Character.getNumericValue(cleanCpf.charAt(9))) {
                return false;
            }

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(cleanCpf.charAt(i)) * (11 - i);
            }
            int secondDigit = 11 - (sum % 11);
            if (secondDigit > 9) {
                secondDigit = 0;
            }

            return secondDigit == Character.getNumericValue(cleanCpf.charAt(10));

        } catch (Exception e) {
            return false;
        }
    }
}