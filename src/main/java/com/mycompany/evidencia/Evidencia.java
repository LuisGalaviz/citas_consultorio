/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.evidencia;
import java.util.Scanner;

public class Evidencia {

    static String[] mn = new String[100];
    static String[] me = new String[100];
    
    static String[] pn = new String[100];
    static String[] pe = new String[100];
    static String[] pv = new String[100];
    
    static String[] cf = new String[100];
    static String[] ch = new String[100];
    
    static int totalmedicos = 0;
    static int totalpacientes = 0;
    static int totalcitas = 0;
    static int[] cp = new int[100]; 
    static int[] cm = new int[100];

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String usuario="admin";
        String contrasena="1234";
        
       
        while (true) {
        System.out.println();
        System.out.println();
        System.out.println ("Bienvenidos al sistema de administracion de citas del consultorio clinico");
        System.out.println ("---------------INICIAR SESION---------------");
        System.out.println();
        
        System.out.print ("Usuario: ");
        String usu = entrada.nextLine(); 
        System.out.print ("Contrasena: ");
        String con = entrada.nextLine();
        System.out.println();
        
        
        if (usu.equals(usuario) && con.equals(contrasena)){
            System.out.println ("Bienvenido, que desea realizar hoy?");
            menu();
            break;
        }
        else {
            System.out.println ("Usuario no reconocido");
        }
    }
    }
    
    static void menu(){
        System.out.println();
        System.out.println("1. Dar de alta a medico");
        System.out.println("2. Dar de alta a paciente");
        System.out.println("3. Crear cita");
        System.out.println("4. Listar medicos");
        System.out.println("5. Listar pacientes");
        System.out.println("6. Listar citas");
        System.out.println("7. Finalizar");
        System.out.println();
        seleccion();
    } 
    
    static void seleccion(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Selecciona una opcion: ");
        int num = entrada.nextInt();
        System.out.println();
        
        switch (num){
            case 1:
                medicoadd();
                break;
            case 2:
                pacienteadd();
                break;
            case 3:
                citaadd();
                break;
            case 4:
                medicolist();
                break;
            case 5:
                pacientelist();
                break;
            case 6:
                citalist();
                break;
            case 7:
                end();
                break;
        }
        
    } 
    
    //Numero 1
    static void medicoadd(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("1. Dar de alta a medico");
        System.out.print("Nombre del medico: ");
        mn[totalmedicos] = entrada.nextLine();
        System.out.print("Especialidad del medico: ");
        me[totalmedicos] = entrada.nextLine();
        
        totalmedicos++;
        menu();
    }
    
    //Numero 2
    static void pacienteadd(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("2. Dar de alta a paciente");
        System.out.print("Nombre del paciente: ");
        pn[totalpacientes] = entrada.nextLine();
        System.out.print("Estado del paciente: ");
        pe[totalpacientes] = entrada.nextLine();
        System.out.print("El paciente viene a: ");
        pv[totalpacientes] = entrada.nextLine();
        totalpacientes++;
        
        System.out.println("");
        System.out.println("Quieres agender una cita?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Opcion: ");
        int ele = entrada.nextInt();
        
        if (ele == 1){
            System.out.println("");
            citaadd();
        }
        else 
        {
            menu();
        }
    }
    
    //Numero 3
    static void citaadd(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("3. Crear una cita");
        System.out.print("Fecha: ");
        String fecha = entrada.nextLine();
        System.out.print("Hora: ");
        String hora = entrada.nextLine();
        
        System.out.println("");
        System.out.println("A que paciente sera asignada esta cita?");
        System.out.println("");
        for (int i = 0; i < totalpacientes; i++) {
        System.out.println((i+1) + ". " + pn[i] + ", " + pe[i] + ", " + pv[i]);
        }
        
        int ele = -1;
    do {
        System.out.print("Elegir un paciente [1-" + totalpacientes + "]: ");
        if (entrada.hasNextInt()) {
            ele = entrada.nextInt();
        } else {
            entrada.next(); 
        }
    } while (ele < 1 || ele > totalpacientes);
    entrada.nextLine(); 
    
        System.out.println("");
     System.out.println("A que medico sera asignada esta cita?");
    for (int i = 0; i < totalmedicos; i++) {
        System.out.println((i+1) + ". " + mn[i] + ", " + me[i]);
    }
    
    int eleMedico = -1;
    do {
        System.out.println("");
        System.out.print("Elegir un medico [1-" + totalmedicos + "]: ");
        if (entrada.hasNextInt()) {
            eleMedico = entrada.nextInt();
        } else {
            entrada.next();
        }
    } while (eleMedico < 1 || eleMedico > totalmedicos);
    entrada.nextLine();

    cf[totalcitas] = fecha;
    ch[totalcitas] = hora;
    cp[totalcitas] = ele - 1; 
    cm[totalcitas] = eleMedico - 1; 
    totalcitas++;
        
        menu();
    }
    
    //Numero 4
    static void medicolist(){
        System.out.println("4. Listar medicos");
        System.out.println();
        System.out.println("Nombre del medico y especialidad: ");
        
        for (int i = 0; i < totalmedicos; i++) {
        System.out.println((i+1) + ". " + mn[i] + ", " + me[i]);
        }
        
        menu();
    }
    
    //Numero 5
    static void pacientelist(){
        System.out.println("5. Listar pacientes");
        System.out.println();
        System.out.println("Nombre del paciente, estado y a que viene: ");
        
        for (int i = 0; i < totalpacientes; i++) {
        System.out.println((i+1) + ". " + pn[i] + ", " + pe[i] + ", " + pv[i]);
        }
        
        menu();
    }
    
    //Numero 6
    static void citalist(){
        System.out.println("6. Listar citas");
        System.out.println();
        System.out.println("Fecha y hora de la consulta: ");
        
        for (int i = 0; i < totalcitas; i++) {
            int pacienteIndex = cp[i];
            String nombrePaciente = pn[pacienteIndex] + " " + pe[pacienteIndex];
            System.out.println((i + 1) + ". " + cf[i] + ", " + ch[i] + " - Paciente: " + nombrePaciente);        }
        
        menu();
    }
    
    //Numero 7
    static void end(){ 
        System.out.println("Gracias por usar el programa.");
    } 
    
} 