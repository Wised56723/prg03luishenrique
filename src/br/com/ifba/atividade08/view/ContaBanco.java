/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08.view;

import java.util.List;

/**
 *
 * @author ADM
 */
public class ContaBanco {
    
    public Integer numConta;
    protected TipoContaEnum tipo; // ← Ultilizei Enum !!!
    private String dono;
    private Float saldo;
    private Boolean status;
    
    // Construtor padrão, vazio.
    public ContaBanco(){
    }
    
    // Construtor com todos argumentos.
    public ContaBanco(Integer numConta, TipoContaEnum tipo, String dono){
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = 0F;
        this.status = false;
    }
    
   // Metodo responsavel por abrir a conta, passando como parametro numero da conta, tipo da conta e nome do dono da conta.
    public void abrirConta(Integer numConta, TipoContaEnum tipo, String dono){
        
        status = true; // Mudo o status da conta para ativo.
        
        this.numConta = numConta; // Número da Conta.
        this.tipo = tipo; // Informo qual o tipo de conta CP ou CC.
        this.dono = dono; // O usuário passa seu nome.
        
        // Verifico se é CP, se for recebe 150, logo se não for só pode ser CC então recebe 50.
        if(tipo == TipoContaEnum.CP){ 
            saldo = 150F;
        }else{
            saldo = 50F;
        }
        
    }
    
    // Método para fechar uma conta
    public void fecharConta(List<ContaBanco> contaBanco, Integer numeroDaConta){
            
        // Recebe do metodo getByIdContaBanco a conta procurada
        ContaBanco contaEncontrada = getByIdContaBanco(contaBanco, numeroDaConta);
                
        //Verifica se o saldo é igual a zero.
        if(contaEncontrada.saldo == 0){
                    
            contaBanco.remove(contaEncontrada);
            
            System.out.println("Conta Removida.");
                
            // Se for diferente de zero não Excluir.
        }else{
            System.out.println("VALOR DIFERENTE DE 0, CONTA NAO PODE SER EXCLUIDA.");
        }    
 
    }
    
    public void depositar(List<ContaBanco> contaBanco, Integer numeroDaConta, Float valorDepositado){
        
        // Recebe do metodo getByIdContaBanco a conta procurada
        ContaBanco contaEncontrada = getByIdContaBanco(contaBanco, numeroDaConta);
        
        if (contaEncontrada == null) {
        System.out.println("Conta não encontrada.");
        return;
        }

        if (!contaEncontrada.status) {
            System.out.println("Conta está inativa. Não é possível depositar.");
            return;
        }

        contaEncontrada.saldo += valorDepositado;
        System.out.println("Depósito de R$ " + valorDepositado + " realizado com sucesso.");
        
    }
    
    public void sacar(List<ContaBanco> contaBanco, Integer numeroDaConta, Float valorSacado){
        
        // Recebe do metodo getByIdContaBanco a conta procurada
        ContaBanco contaEncontrada = getByIdContaBanco(contaBanco, numeroDaConta);
        
         if (contaEncontrada == null) {
        System.out.println("Conta não encontrada.");
        return;
        }

        if (!contaEncontrada.status) {
            System.out.println("Conta está inativa. Não é possível sacar.");
            return;
        }

        if (contaEncontrada.saldo < valorSacado) {
            System.out.println("Saldo insuficiente para saque.");
            return;
        }

        contaEncontrada.saldo -= valorSacado;
        System.out.println("Saque de R$ " + valorSacado + " realizado com sucesso.");
    }

    // Pega A conta pelo ID
    public ContaBanco getByIdContaBanco(List<ContaBanco> contaBanco, Integer numeroDaConta){
        
        // Lista que armazena as contas
        List<ContaBanco> procurarContaBanco = contaBanco;
        
        // Percore a Lista
        for(ContaBanco conta : procurarContaBanco){
            
            // Procura procura pelo index
            if(conta.getNumConta().equals(numeroDaConta)){
                
                // Recebe o index do Lista
                int index = procurarContaBanco.indexOf(conta);
                ContaBanco contaBancoUsuario = procurarContaBanco.get(index);
                
                return contaBancoUsuario;         
                
            }
        }
        
        return null;
    }
    
    
    @Override
    public String toString() {
        return "ContaBanco {" +
               "numConta=" + numConta +
               ", tipo=" + tipo +
               ", dono='" + dono + '\'' +
               ", saldo=" + saldo +
               ", status=" + status +
               '}';
    }
  
    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public TipoContaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoContaEnum tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public Float getSaldo() {
        return saldo;
    }

    private void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
   
}