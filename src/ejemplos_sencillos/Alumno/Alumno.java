package ejemplos_sencillos.Alumno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Alumno {

    private String nombre;
    private String dni;
    private static List<ArrayList<String>> alumnos = new ArrayList<>();

        public  Alumno(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nombre:");
            nombre = scanner.next();
            System.out.println("Dni:");
            dni = scanner.next();

            boolean existe = alumnos.stream().anyMatch(a -> a.get(1).equalsIgnoreCase(dni));

            if(existe || !dni.matches("\\d{8}[A-Za-z]")){
                System.out.println("El DNI ya está registrado o formato dni no valido. No se puede agregar el alumno.");
            }else{
                ArrayList<String> nuevoAlumno = new ArrayList<>();
                nuevoAlumno.add(nombre);
                nuevoAlumno.add(dni);
                alumnos.add(nuevoAlumno);
                System.out.println("Se ha metido: " + nuevoAlumno);
            }

            System.out.println("alumnos actuales: " + Arrays.toString(alumnos.toArray()));
            System.out.println();

        }

        public static void VerAlumnos() {
            System.out.println("alumnos actuales: " + Arrays.toString(alumnos.toArray()));
        }




}
