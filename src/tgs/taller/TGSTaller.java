/*
Integrantes
Ilder Antonio Lopez Asprilla
Jaider Andres Valencia Mena
Jhon Fredy Gomez Cuartas
 */
package tgs.taller;

import java.util.ArrayList;
import java.util.List;

public class TGSTaller {

    public static void main(String[] args) {
        List<Matricula> listaMatriculas = new ArrayList<>();

        listaMatriculas.add(new Matricula("Juan Torres", "Masculino", 1024001123, true));
        listaMatriculas.add(new Matricula("María Solís", "Femenino", 1024002456, true));
        listaMatriculas.add(new Matricula("Roberto Gómez", "Masculino", 1023987654, true));

        listaMatriculas.add(new Matricula("Laura Díaz", "Femenino", 1022112233, false));
        listaMatriculas.add(new Matricula("Pedro Ríos", "Masculino", 1021554466, false));
        listaMatriculas.add(new Matricula("Andrea Vega", "Femenino", 1024003789, false));

        GeneralES.imp("Programa Incripcion Deportes");
        int op = 0;
        do {

            op = GeneralES.leaEntero("Menu principal\n"
                    + "1. Inscribirse a un deporte\n"
                    + "2. Mostrar Lista de Estudiantes\n"
                    + "0. Salir\n");
            switch (op) {
                case 1:
                    String genero;
                    boolean mfr = false;
                    int opt = 0,
                            matriculaIngresada;
                    matriculaIngresada = GeneralES.leaEntero("Ingrese su numero de Identificacion");

                    Matricula matriculaEncontrada = null;
                    for (Matricula m : listaMatriculas) {
                        if (matriculaIngresada == m.getId()) {
                            matriculaEncontrada = m; // Guarda el objeto encontrado
                            break; // ¡Importante! Detener el bucle en cuanto se encuentra
                        }
                    }

                    // 3. Bloque de LÓGICA (FUERA DEL BUCLE FOR)
                    if (matriculaEncontrada != null) {
                        // A. La matrícula FUE encontrada
                        GeneralES.imp("Matrícula encontrada: " + matriculaEncontrada.getNombre() + " con Documento No. "
                                + matriculaEncontrada.getId());

                        // B. Evaluar el estado de la matrícula encontrada
                        if (matriculaEncontrada.isEstado()) {
                            GeneralES.imp("Estado: ACTIVO. Puede continuar con el registro.");
                        } else {
                            GeneralES.imp("Estado: INACTIVO. No puede continuar.");
                            break;
                        }

                    } else {
                        // C. La matrícula NO FUE encontrada en toda la lista
                        GeneralES.imp("La matrícula " + matriculaIngresada + " NO existe en la Base de Datos.");
                        break;
                    }
                    do {
                        opt = GeneralES.leaEntero("Tiene usted Movilidad Fisica Reducida?\n"
                                + "1.Si\n"
                                + "2.No");
                    } while (opt != 1 && opt != 2);
                    if (opt == 1) {
                        mfr = true;
                    } else {
                        mfr = false;
                    }
                    matriculaEncontrada.setMfr(mfr);

                    if (matriculaEncontrada.isMfr() == true) {
                        opt = GeneralES.leaEntero("\nDeportes disponibles:\n"
                                + "Escoja el deporte al que quiere unirse\n"
                                + "1.Ajedrez\n"
                                + "0.Ninguno\n");
                        GeneralES.imp("Inscripcion completada\n"
                                + "Nombre: " + matriculaEncontrada.getNombre() + "\n"
                                + "Genero: " + matriculaEncontrada.getGenero() + "\n"
                                + "Discapacidad: " + matriculaEncontrada.isMfr());
                        if (opt == 1) {
                            GeneralES.imp("Deporte: Ajedrez");
                            matriculaEncontrada.setDeporte("Ajedrez");
                            break;
                        } else {
                            GeneralES.imp("Deporte: Ninguno");
                            matriculaEncontrada.setDeporte("Ninguno");
                            break;
                        }

                    } else if (matriculaEncontrada.getGenero() == "Femenino") {
                        opt = GeneralES.leaEntero("Deportes disponibles:\n"
                                + "Escoja el deporte al que quiere unirse\n"
                                + "1.Baloncesto\n"
                                + "2.Natacion\n"
                                + "3.Voleibol\n"
                                + "4.Atletismo\n"
                                + "0.Ninguno\n");

                        GeneralES.imp("Inscripcion completada\n"
                                + "Nombre: " + matriculaEncontrada.getNombre() + "\n"
                                + "Genero: " + matriculaEncontrada.getGenero() + "\n"
                                + "Discapacidad: " + matriculaEncontrada.isMfr());
                        switch (opt) {
                            case 1:
                                GeneralES.imp("Deporte: Baloncesto");
                                matriculaEncontrada.setDeporte("Baloncesto");
                                break;
                            case 2:
                                GeneralES.imp("Deporte: Natación");
                                matriculaEncontrada.setDeporte("Natacion");
                                break;
                            case 3:
                                GeneralES.imp("Deporte: Voleibol");
                                matriculaEncontrada.setDeporte("Voleibol");
                                break;
                            case 4:
                                GeneralES.imp("Deporte: Atletismo");
                                matriculaEncontrada.setDeporte("Atletismo");
                                break;
                            case 0:
                                GeneralES.imp("Deporte: Ninguno");
                                matriculaEncontrada.setDeporte("Ninguno");
                                break;
                            default:
                                GeneralES.imp("Opcion no valida");
                                break;

                        }
                    } else {
                        opt = GeneralES.leaEntero("Deportes disponibles:\n"
                                + "Escoja el deporte al que quiere unirse\n"
                                + "1.Natacion\n"
                                + "2.Voleibol\n"
                                + "3.Atletismo\n"
                                + "0.Ninguno\n");
                        GeneralES.imp("Inscripcion completada\n"
                                + "Nombre: " + matriculaEncontrada.getNombre() + "\n"
                                + "Genero: " + matriculaEncontrada.getGenero() + "\n"
                                + "Discapacidad: " + matriculaEncontrada.isMfr());
                        switch (opt) {
                            case 1:
                                GeneralES.imp("Deporte: Natación");
                                matriculaEncontrada.setDeporte("Natacion");
                                break;
                            case 2:
                                GeneralES.imp("Deporte: Voleibol");
                                matriculaEncontrada.setDeporte("Voleibol");
                                break;
                            case 3:
                                GeneralES.imp("Deporte: Atletismo");
                                matriculaEncontrada.setDeporte("Atletismo");
                                break;
                            case 0:
                                GeneralES.imp("Deporte: Ninguno");
                                matriculaEncontrada.setDeporte("Ninguno");
                                break;
                            default:
                                GeneralES.imp("Opcion no valida");
                                break;
                        }
                    }
                case 2:
                    for (Matricula matricula : listaMatriculas) {
                        // Cuando imprimes el objeto, Java llama automáticamente al método toString()
                        System.out.println(matricula);
                    }

                    GeneralES.imp("----------------------------------------");
                    GeneralES.imp("Total de elementos: " + listaMatriculas.size());
                    break;

                default:
                    GeneralES.imp("Opcion no valida");
                    break;
            }

        } while (op != 0);

    }

}
