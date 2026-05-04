🏋️‍♂️ Sistema de Gestión de Gimnasio (Java)Este repositorio contiene un ejemplo práctico de Programación Orientada a Objetos (POO) en Java, diseñado para la gestión de inscripciones en un centro deportivo.🛠️ Estructura del Sistema1. 

📜 Interfaz de ContratoLa interfaz Inscribible define las acciones básicas que cualquier actividad debe poder realizar.

Javapublic interface Inscribible {
    boolean inscribir(); // ✅ Devuelve true si se logra inscribir
    boolean cancelar();  // ❌ Devuelve true si se logra cancelar
}

🏗️ Modelo de Datos (Jerarquía de Clases)🧬 Clase Abstracta: ActividadEs la base para todos los tipos de ejercicios. Define los atributos comunes y el estado de ocupación.
  
  Javaabstract class Actividad implements Inscribible {
    protected int id;           // 🆔 Identificador único
    protected double precioBase; // 💰 Coste inicial
    protected boolean llena;     // 🚦 Estado: ¿Está ocupada?

    public Actividad(int id, double precioBase) {
        this.id = id;
        this.precioBase = precioBase;
        this.llena = false; // 🟢 Por defecto empieza libre
    }

    public abstract double calcularPrecio(); // 🧮 Lógica polimórfica según el tipo

    @Override
    public boolean inscribir() {
        if (!llena) {
            llena = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelar() {
        if (llena) {
            llena = false;
            return true;
        }
        return false;
    }

    // Getters
    public int getId() { return id; }
    public boolean isLlena() { return llena; }
}


👥 Especialización: ActividadGrupalAplica lógica de negocio específica: descuentos por volumen.Javaclass ActividadGrupal extends Actividad {
    private int maxPersonas;

    public ActividadGrupal(int id, double precio, int max) {
        super(id, precio);
        this.maxPersonas = max;
    }

    @Override
    public double calcularPrecio() {
        // 📉 Si son más de 10 personas, se aplica un 10% de descuento
        if (maxPersonas > 10) return precioBase * 0.9;
        return precioBase;
    }
}

🧠 El Cerebro del Sistema: GimnasioClase encargada de gestionar las colecciones y la lógica de negocio principal. ColecciónTipo de DatoPropósitoHashSetSocioEvitar socios duplicados por DNIArrayListActividadCatálogo de actividades disponiblesLinkedListInscripcionHistorial dinámico de altas y bajas

Javaimport java.util.*;
class Gimnasio {
    private Set<Socio> socios = new HashSet<>(); 
    private List<Actividad> actividades = new ArrayList<>(); 
    private List<Inscripcion> inscripciones = new LinkedList<>(); 

    // 🔍 Buscar socio por DNI
    public Socio buscarSocio(String dni) {
        for (Socio s : socios) {
            if (s.getDni().equals(dni)) return s;
        }
        return null;
    }

    // 📝 Realizar nueva inscripción
    public boolean realizarInscripcion(String dni, int idAct) {
        Socio s = buscarSocio(dni);
        Actividad a = buscarActividad(idAct);

        if (s != null && a != null && !a.isLlena()) {
            if (a.inscribir()) {
                inscripciones.add(new Inscripcion(s, a));
                return true; // ✨ Éxito
            }
        }
        return false; // ⚠️ Fallo en validación
    }

    // 🗑️ Eliminar/Cancelar inscripción
    public boolean eliminarInscripcion(int idAct) {
        Actividad a = buscarActividad(idAct);
        if (a != null && a.cancelar()) {
            return inscripciones.removeIf(i -> i.getActividad().getId() == idAct);
        }
        return false;
    }
}
4. 🕹️ Interfaz de Usuario: AppGimnasioPunto de entrada con menú interactivo por consola.Javaimport java.util.Scanner;

public class AppGimnasio {
    public static void main(String[] args) {
        Gimnasio gym = new Gimnasio();
        Scanner sc = new Scanner(System.in);

        // 🔋 Pre-carga de datos
        gym.registrarSocio(new Socio("111A", "Juan"));
        gym.registrarSocio(new Socio("222B", "Marta"));
        gym.agregarActividad(new ActividadGrupal(1, 30.0, 15));

        // 🔄 Bucle de control
        int opcion = 0;
        do {
            System.out.println("\n--- 📟 MENÚ GESTIÓN GIMNASIO ---");
            System.out.println("1️⃣ Reservar Actividad");
            System.out.println("2️⃣ Cancelar Actividad");
            System.out.println("3️⃣ Listar Inscripciones");
            System.out.println("4️⃣ Ver Disponibles");
            System.out.println("5️⃣ Salir");
            
            // ... lógica de Switch-Case ...

        } while (opcion != 5);
        sc.close();
    }
}
