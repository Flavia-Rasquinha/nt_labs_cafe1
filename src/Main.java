import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        ScanTutorial scan = new ScanTutorial();

        Integer indice = selectedItem(scan);
        Double valor = coletarValor(scan, indice);

    }

    private static Integer selectedItem(ScanTutorial scan) {
        boolean optionSelected = false;
        Integer indice = 0;
        do {
            System.out.println(Constants.MENSAGENS.INICIO);
            System.out.println(Constants.MENSAGENS.ITENS);

            indice = scan.coletarInteiro();

            if (indice > 0 && indice < 5) {
                optionSelected = true;
            } else {
                System.out.println(Constants.ERROS.OPCAO_INVALIDA);
            }

        } while (optionSelected == false);

        return indice;
    }

    private static Double coletarValor(ScanTutorial scan, Integer indice) {
        Double valor = 0.0;
        boolean optionSelected = false;
        do {
            System.out.println(Constants.MENSAGENS.PAGAMENTO);
            valor = scan.coletarDouble();

            switch (indice) {
                case 1:
                    if (valor >= 3.50) {
                        optionSelected = true;
                    }
                    devolverTroco(valorTroco(scan, 3.50, valor));
                    break;
                case 2:
                    if (valor >= 3.55) {
                        optionSelected = true;
                    }
                    devolverTroco(valorTroco(scan, 3.55, valor));
                    break;
                case 3:
                    if (valor >= 3.25) {
                        optionSelected = true;
                    }
                    devolverTroco(valorTroco(scan, 3.25, valor));
                    break;
                case 4:
                    if (valor >= 3.75) {
                        optionSelected = true;
                    }
                    devolverTroco(valorTroco(scan, 3.75, valor));
                    break;
            }

            if (optionSelected == false) {
                System.out.println(Constants.ERROS.VALOR_INVALIDO);
            }

        } while (optionSelected == false);

        return valor;
    }

    private static Double valorTroco(ScanTutorial scan, Double valorProduto, Double valorInserido) {
        Boolean validacao = true;
        do {

            if (valorProduto > valorInserido) {
                validacao = false;
                System.out.println(Constants.ERROS.SALDO_INVALIDO);
            }
            if (valorInserido > 5.00) {
                validacao = false;

                System.out.println(Constants.ERROS.LIMITE_INVALIDO);
                System.out.println(Constants.MENSAGENS.NOVO_VALOR);
                valorInserido = scan.coletarDouble();
            }
            if ( valorInserido <= 5.00){
                validacao = true;
            }
        } while (validacao == false);
        System.out.println("Seu troco: " + (double) Math.round((valorInserido - valorProduto) * 1000d) / 1000d);
        return (double) Math.round((valorInserido - valorProduto) * 1000d) / 1000d;

    }

    private static void devolverTroco(Double valorTroco) {
        double v2 = 0, v1 = 0, v50 = 0, v25 = 0, v10 = 0;

        while ( valorTroco != 0) {
            if (valorTroco >= 2) {

                v2 = valorTroco / 2;
                valorTroco = valorTroco % 2;
                valorTroco = (double) Math.round((valorTroco) * 1000d) / 1000d;

            } else if (valorTroco >= 1) {
                v1 = valorTroco / 1;
                valorTroco = valorTroco % 1;
                valorTroco = (double) Math.round((valorTroco) * 1000d) / 1000d;

            } else if (valorTroco >= 0.50) {
                v50 = valorTroco / 0.50;
                valorTroco = valorTroco % 0.50;
                valorTroco = (double) Math.round((valorTroco) * 1000d) / 1000d;

            } else if (valorTroco >= 0.25) {
                v25 = valorTroco / 0.25;
                valorTroco = valorTroco % 0.25;
                valorTroco = (double) Math.round((valorTroco) * 1000d) / 1000d;

            } else if (valorTroco >= 0.10) {
                v10 = valorTroco / 0.10;
                valorTroco = valorTroco % 0.10;
                valorTroco = (double) Math.round((valorTroco) * 1000d) / 1000d;
            }

        }
        System.out.println((int) v2 + " notas de R$2,00");
        System.out.println((int)v1 + " moedas de R$1,00");
        System.out.println((int)v50 + " moedas de R$0,50");
        System.out.println((int)v25 + " moedas de R$0,25");
        System.out.println((int)v10 + " moedas de R$0,10");


    }
}
