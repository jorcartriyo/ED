/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco2;

/**
 *
 * @author Router1
 */
public class Banco1Dam {
    
    Clientes cliente = new Clientes();
    
    
        public static void main(String[] args) {

  Banco2 b = new Banco2("TubbiesBank", 5);
  int nPo = b.abrirCuenta("Po", 500);
  int nDixy = b.abrirCuenta("Dixy", 500);
  int nTinkyWinky = b.abrirCuenta("Tinky Winky", 500);
  int nLala = b.abrirCuenta("Lala", 500);
  System.out.println(b);
  b.ingreso(nPo, 100);
  b.debito(nDixy, 100);
  b.transferencia(nTinkyWinky, nLala, 100);
  System.out.println(b);
  b.cerrarCuenta(nPo);
  b.ingreso(nDixy,200);
  System.out.println(b);
    }
}
