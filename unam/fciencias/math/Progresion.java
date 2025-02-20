package edd.unam.fciencias.math.Progresión.java;

public abstract class Progresion {

    /*
     * Valor actual de la progresión
     */
    private int valorActual;

     /*
      * Constructor de la clase
      */
      public Progresion () {
        valorActual = 0;
      }

      /*
       * Método que devuelve el valor actual de la progresión
       */
      public int getValorActual() {
        return valorActual;
      }

       /*
        * Método para reestablecer el valor incial de la progresión
        */
        public void reestablecer() {
            valorActual = 0;
        }

        /*
         * Método que devuelve el siguiente valor de la progresión
         */
        public abstract int siguiente();

        /*
        * Método que regresa el i-ésimo valor de la progresión
        * 
        * Empieza en el valor incial y cuenta i-1
        */
        public int getI(int i) {
            reestablecer();
            for (int j = 0; j < i - 1; j++ ) {
                siguiente();
            }
            return valorActual;
        }

        /*
        * Método para imprimir los primeros n-valores de la progresión
        */
        public void imprime(int k) {
            for (int i = 0; i < k; i++) {
                System.out.println(getValorActual() + " ");
                siguiente();
            }
            System.out.println();
        }     
}