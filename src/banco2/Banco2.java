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
public class Banco2 {
 private final static int NUMCTALIBRE = 1001;
 private String nombre;
 private int ppl;
 private int unca;
 private Cuenta[] cta;
 
 public Banco2(String st) {
  
  cta = new Cuenta[10];
  nombre = st;
  ppl = 0;
  unca = NUMCTALIBRE;
 }
 public Banco2(String st, int pos) {
  cta = new Cuenta[pos];
  nombre = st;
  ppl = 0;
  unca = NUMCTALIBRE;
 }
 
 public int abrirCuenta(String nombre){

  if(ppl >= cta.length) {
   Cuenta[] cuentaAux = new Cuenta[cta.length * 2];
   System.arraycopy(cta, 0, cuentaAux, 0, ppl);
   cta = cuentaAux;
  }
  cta[ppl] = new Cuenta(nombre, unca);
  ppl++;
  unca++;
  
  return unca-1;
 }

 public int abrirCuenta(String nombre, double din){

  if(ppl >= cta.length) {
   Cuenta[] cuentaAux = new Cuenta[cta.length * 2];
   System.arraycopy(cta, 0, cuentaAux, 0, ppl);
   cta = cuentaAux;
  }
  cta[ppl] = new Cuenta(nombre, unca, din);
  ppl++;
  unca++;
  
  return unca-1;
 } 

 private int posicionDeCuenta(int num){
  int pos = 0;
  boolean esta = false;
  for(int i = 0; i < ppl; i++){
   if (cta[i].cuenta()==num) pos = i; esta = true;
  }
  if(!esta) throw new RuntimeException("No existe la cuenta dada");
  return pos;
 }
public void cerrarCuenta(int num) {

  int pos = posicionDeCuenta(num);
  for (int i = pos; i<cta.length-2; i++) {
   cta[i]=cta[i+1];
  }
  ppl--;
}

 public void ingreso(int numeroDeCuenta, double din) {
  int pos = posicionDeCuenta(numeroDeCuenta);
  cta[pos].ingreso(din);
 }

 public double debito(int numeroDeCuenta, double din){
  double dineroCargado;
  int pos = posicionDeCuenta(numeroDeCuenta);

  if(cta[pos].saldo()>=din) {cta[pos].retirada(din);dineroCargado = din;}
  else {
   cta[pos].retirada(cta[pos].saldo());
   dineroCargado = cta[pos].saldo();
  }
  return dineroCargado;
 }

 

 public double saldo(int numeroDeCuenta) {
  int pos = posicionDeCuenta(numeroDeCuenta);
  return cta[pos].saldo();
 }

 public double transferencia(int num1, int num2, double din) { //transfiere din dinero de la cuenta num1 a la cuenta num 2
  double dineroDeTransferencia = this.debito(num1, din);
  this.ingreso(num2, dineroDeTransferencia);
  
  return dineroDeTransferencia;
 }

 public String toString(){
  String res ="Banco " + nombre + ": [  ";
  for(int i = 0; i<ppl; i++) {

    res= res + "\n"+ cta[i].toString();
  }
  return res;
 }
}
