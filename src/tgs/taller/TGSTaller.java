/*
Integrantes
Ilder Antonio Lopez Asprilla
Jaider Andres Valencia Mena
Jhon Fredy Gomez Cuartas
 */
package tgs.taller;
import java.time.LocalDateTime;
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
        int cuposBaloncesto = 8, cuposNatacion = 10, cuposVoleibol = 12, cuposAtletismo = 15, cuposAjedrez = 6;

        do {

            op = GeneralES.leaEntero("Menu principal\n"
                    + "1. Inscribirse a un deporte\n"
                    + "2. Mostrar Lista de Estudiantes\n"
                    + "0. Salir\n");
            switch (op) {
                case 1:                    
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
                                + matriculaEncontrada.getId() + "\n");

                        // B. Evaluar el estado de la matrícula encontrada
                        if (matriculaEncontrada.isEstado()) {
                            GeneralES.imp("Estado: ACTIVO. Puede continuar con el registro.\n");
                        } else {
                            GeneralES.imp("Estado: INACTIVO. No puede continuar.\n");
                            break;
                        }

                    } else {
                        // C. La matrícula NO FUE encontrada en toda la lista
                        GeneralES.imp("La matrícula " + matriculaIngresada + " NO existe en la Base de Datos.\n");
                        break;
                    }
                    do {
                        opt = GeneralES.leaEntero("Tiene usted Movilidad Fisica Reducida?\n"
                                + "1.Si\n"
                                + "2.No");

                        if (opt != 1 && opt != 2) {
                            GeneralES.imp("Opcion no valida, por favor intente de nuevo\n");
                        }
                    } while (opt != 1 && opt != 2);
                    if (opt == 1) {
                        mfr = true;
                    } else {
                        mfr = false;
                    }
                    matriculaEncontrada.setMfr(mfr);

                    if (matriculaEncontrada.isMfr() == true) {
                        do {
                            opt = GeneralES.leaEntero("\nDeportes disponibles:\n"
                                    + "Escoja el deporte al que quiere unirse\n"
                                    + "1.Ajedrez (Cupos disponibles: " + cuposAjedrez + ")\n");
                            if (opt == 1) {
                                if (cuposAjedrez > 0) {
                                    matriculaEncontrada.setDeporte("Ajedrez");
                                    cuposAjedrez--;
                                } else {
                                    GeneralES.imp("Lo sentimos, no hay cupos disponibles para Ajedrez\n");
                                    break;
                                }
                            } else {
                                GeneralES.imp("Opcion no valida, por favor intente de nuevo\n");
                            }
                        } while (opt != 1);

                        if (cuposAjedrez >= 0 && opt == 1) {
                            GeneralES.imp("Inscripcion completada\n"
                                    + "Nombre: " + matriculaEncontrada.getNombre() + "\n"
                                    + "Genero: " + matriculaEncontrada.getGenero() + "\n"
                                    + "Discapacidad: " + matriculaEncontrada.isMfr() + "\n"
                                    + "Deporte: " + matriculaEncontrada.getDeporte());
                        }
                        break;
                    } else if (matriculaEncontrada.getGenero() == "Femenino") {
                        do {
                            opt = GeneralES.leaEntero("Deportes disponibles:\n"
                                    + "Escoja el deporte al que quiere unirse\n"
                                    + "1.Baloncesto (Cupos disponibles: " + cuposBaloncesto + ")\n"
                                    + "2.Natacion (Cupos disponibles: " + cuposNatacion + ")\n"
                                    + "3.Voleibol (Cupos disponibles: " + cuposVoleibol + ")\n"
                                    + "4.Atletismo (Cupos disponibles: " + cuposAtletismo + ")\n");

                            if (opt < 1 || opt > 4) {
                                GeneralES.imp("Opcion no valida, por favor intente de nuevo\n");
                            }
                        } while (opt < 1 || opt > 4);

                        boolean inscripcionExitosa = false;
                        switch (opt) {
                            case 1:
                                if (cuposBaloncesto > 0) {
                                    matriculaEncontrada.setDeporte("Baloncesto");
                                    cuposBaloncesto--;
                                    inscripcionExitosa = true;
                                } else {
                                    GeneralES.imp("Lo sentimos, no hay cupos disponibles para Baloncesto\n");
                                }
                                break;
                            case 2:
                                if (cuposNatacion > 0) {
                                    matriculaEncontrada.setDeporte("Natacion");
                                    cuposNatacion--;
                                    inscripcionExitosa = true;
                                } else {
                                    GeneralES.imp("Lo sentimos, no hay cupos disponibles para Natación\n");
                                }
                                break;
                            case 3:
                                if (cuposVoleibol > 0) {
                                    matriculaEncontrada.setDeporte("Voleibol");
                                    cuposVoleibol--;
                                    inscripcionExitosa = true;
                                } else {
                                    GeneralES.imp("Lo sentimos, no hay cupos disponibles para Voleibol\n");
                                }
                                break;
                            case 4:
                                if (cuposAtletismo > 0) {
                                    matriculaEncontrada.setDeporte("Atletismo");
                                    cuposAtletismo--;
                                    inscripcionExitosa = true;
                                } else {
                                    GeneralES.imp("Lo sentimos, no hay cupos disponibles para Atletismo\n");
                                }
                                break;
                        }

                        if (inscripcionExitosa) {
                            GeneralES.imp("Inscripcion completada\n"
                                    + "Nombre: " + matriculaEncontrada.getNombre() + "\n"
                                    + "Genero: " + matriculaEncontrada.getGenero() + "\n"
                                    + "Discapacidad: " + matriculaEncontrada.isMfr() + "\n"
                                    + "Deporte: " + matriculaEncontrada.getDeporte()+"\n"
                                    +"Fecha: "+LocalDateTime.now());
                        }
                    } else {
                        do {
                            opt = GeneralES.leaEntero("Deportes disponibles:\n"
                                    + "Escoja el deporte al que quiere unirse\n"
                                    + "1.Natacion (Cupos disponibles: " + cuposNatacion + ")\n"
                                    + "2.Voleibol (Cupos disponibles: " + cuposVoleibol + ")\n"
                                    + "3.Atletismo (Cupos disponibles: " + cuposAtletismo + ")\n");

                            if (opt < 1 || opt > 3) {
                                GeneralES.imp("Opcion no valida, por favor intente de nuevo\n");
                            }
                        } while (opt < 1 || opt > 3);

                        boolean inscripcionExitosa = false;
                        switch (opt) {
                            case 1:
                                if (cuposNatacion > 0) {
                                    matriculaEncontrada.setDeporte("Natacion");
                                    cuposNatacion--;
                                    inscripcionExitosa = true;
                                } else {
                                    GeneralES.imp("Lo sentimos, no hay cupos disponibles para Natación\n");
                                }
                                break;
                            case 2:
                                if (cuposVoleibol > 0) {
                                    matriculaEncontrada.setDeporte("Voleibol");
                                    cuposVoleibol--;
                                    inscripcionExitosa = true;
                                } else {
                                    GeneralES.imp("Lo sentimos, no hay cupos disponibles para Voleibol\n");
                                }
                                break;
                            case 3:
                                if (cuposAtletismo > 0) {
                                    matriculaEncontrada.setDeporte("Atletismo");
                                    cuposAtletismo--;
                                    inscripcionExitosa = true;
                                } else {
                                    GeneralES.imp("Lo sentimos, no hay cupos disponibles para Atletismo\n");
                                }
                                break;                            
                        }

                        if (inscripcionExitosa) {
                            GeneralES.imp("Inscripcion completada\n"
                                    + "Nombre: " + matriculaEncontrada.getNombre() + "\n"
                                    + "Genero: " + matriculaEncontrada.getGenero() + "\n"
                                    + "Discapacidad: " + matriculaEncontrada.isMfr() + "\n"
                                    + "Deporte: " + matriculaEncontrada.getDeporte());
                        }
                    }

                    break;
                case 2:
                    for (Matricula matricula : listaMatriculas) {
                        // Cuando imprimes el objeto, Java llama automáticamente al método toString()
                        System.out.println(matricula);
                    }

                    GeneralES.imp("----------------------------------------");
                    GeneralES.imp("Total de elementos: " + listaMatriculas.size());
                    GeneralES.imp("\n");
                    break;

                case 0:
                    GeneralES.imp("Saliendo del programa...");
                    break;

                default:
                    GeneralES.imp("Opcion no valida");
                    break;
            }

        } while (op != 0);

    }

}
