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
public class Cuenta {
 private String titular;
 private double saldo;
 private int nCuenta;
 
 public Cuenta(String titular, int nCuenta, double saldo) {
  this.titular = titular;
  this.saldo = saldo;
  this.nCuenta = nCuenta;
 }
 public Cuenta(String titular, int nCuenta) {
  this.titular = titular;
  saldo = 0;
  this.nCuenta = nCuenta;
 }

 public void ingreso(double ingreso) {
  saldo += ingreso;
 }
 public void retirada(double retirada) {
  saldo -= retirada;
 }
 
 public String titular() {return titular;}
 public double saldo() {return saldo;}
 public int cuenta() {return nCuenta;}
 
 public String toString() {
  return titular + " con numero de cuenta " + nCuenta + " tiene " + saldo + "€";
 }
}
