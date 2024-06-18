package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;                  //importaciones para la interfaz grafica y los paquetes Vista y Modelo
import VistaGUI.GUI;
import VistaGUI.MenuPrincipal;
import VistaGUI.FormularioActualizacion;
import VistaGUI.FormularioMascota;
import VistaGUI.FormularioEliminacion;
import VistaGUI.PanelConsulta;
import VistaGUI.PanelInformacion;
import VistaGUI.PanelDerechosAutor;
import Modelo.Modelo;


public class Controlador {

    private GUI vista;//iniciacion de variables tipo vista y modelo
    private Modelo modelo;

    public Controlador(GUI vista, Modelo modelo) {//constructor
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {  //clase que permite hacer el loggin en el sistema

        @Override
        public void actionPerformed(ActionEvent e) {//metodo para aprobar o no la entrada al sistema segun los datos ingresados
            String username = vista.getUsername();
            String password = vista.getPassword();
            if (modelo.authenticateUser(username, password)) {
                vista.showMessage("Login successful!");
                abrirMenuPrincipal();
            } else {
                vista.showMessage("Login failed!");
            }
        }
    }

    public void abrirMenuPrincipal() { //Metodos que llaman a las interfazes graficas y las clases restantes
        MenuPrincipal menuPrincipal = new MenuPrincipal(this);
        
        vista.mostrarPanel(menuPrincipal);
    }

    public void abrirFormularioMascota() {
        FormularioMascota formulario = new FormularioMascota(this);
        vista.mostrarPanel(formulario);
    }
     public void abrirFormularioActualizacion() {
        FormularioActualizacion formulario = new FormularioActualizacion(this);
        vista.mostrarPanel(formulario);
    }
    public void abrirFormularioEliminacion() {
        FormularioEliminacion formulario = new FormularioEliminacion(this);
        vista.mostrarPanel(formulario);
    }
    public void abrirPanelConsulta() {
        List<String[]> mascotas = modelo.obtenerRegistrosMascotas();
        PanelConsulta panelConsulta = new PanelConsulta(mascotas, this);
        vista.mostrarPanel(panelConsulta);
    }
    public void abrirPanelInformacionImportante() {
        String informacion = "Según un reporte hecho por Mora (2023) donde expone un estudio realizado por Humane Society International que revela tendencias positivas con respecto al bienestar de los animales de compañía, él estudio asevera que \"Los programas de castración esterilización de perros y gatos callejeros parecen estar dando resultado en el objetivo de disminuir la sobrepoblación de estos animales en Costa Rica\"(parr.1).\n"
                +
                "La esterilización de nuestras mascotas es muy importante, ya que como se lee en la cita anterior disminuye la sobrepoblación de estos animalitos y mitiga la cantidad de estos en condición de calle.\n"
                + // " " +
                "Según señaló la directora ejecutiva de HSI Latinoamérica, Andrea Borel como se cito en Mora (2023): \"Estos son datos vitales que ayudarán a HSI a colaborar con los programas de bienestar animal existentes en Costa Rica para lograr un cambio sostenible, a través del manejo humanitario de la población de perros y gatos, la esterilización asequible y accesible, la atención veterinaria preventiva, la educación pública y una cultura fortalecida de tenencia responsable de mascotas”(parr.5).\n"
                +
                "Debemos ser mas humanos y entender que ningún ser merece afrontarse a situaciones tan adversas como vivir en condición de calle, se debe tener buenos valores y principios que nos hagan responsables y mas sensibles sobre el cuidado de nuestras mascotas.\n\n"
                +
                "A continuación se compartiran algunos puntos importantes que consideramos como fundación son imprencindibles en el bienestar animal:\n"
                +
                "1-Atención veterinaria adecuada: Todos los animales bajo el cuidado de la fundación deben recibir atención veterinaria regular, incluyendo chequeos de salud, vacunas, desparasitación y tratamiento para cualquier enfermedad o lesión.\n"
                +
                "2-Nutrición balanceada: Proporcionar una dieta adecuada y balanceada es esencial para mantener la salud y el bienestar de los animales. Esto implica ofrecer alimentos de alta calidad y en las cantidades adecuadas para cada etapa de la vida.\n"
                +
                "3-Espacio y ambiente adecuados: Los animales necesitan un espacio limpio y seguro donde puedan moverse libremente, descansar y jugar. Proporcionar un ambiente enriquecido con juguetes, áreas de descanso y estimulación mental es clave para su bienestar.\n"
                +
                "4-Socialización y ejercicio: Los perros y gatos son animales sociales que necesitan interacción con otros animales y personas. Es importante ofrecer oportunidades de socialización y ejercicio regular, como paseos, juegos y actividades en grupo.\n"
                +
                "5-Promoción de la adopción responsable: Fomentar la adopción responsable implica educar a los adoptantes potenciales sobre las necesidades y responsabilidades que implica tener una mascota, así como realizar procesos de selección cuidadosos para garantizar que los animales sean adoptados por familias adecuadas.\n"
                +
                "6-Programas de esterilización y castración: La esterilización y castración ayudan a controlar la población de animales sin hogar y a prevenir problemas de salud y comportamiento. Ofrecer programas de esterilización/castración a bajo costo o gratuitos puede ser una forma efectiva de promover el bienestar animal.";
                PanelInformacion panelInformacion = new PanelInformacion(this, informacion);
                vista.mostrarPanel(panelInformacion);
    }
    public void abrirPanelDerechosAutor() {
        String informacion = "Derechos de autor del sistema " + "\n" +
        "~Demian Ramírez Sandoval / Carné: C36462." + "\n" +
                "~Eddy Josue Gonzáles Quíros / Carné: C33417.";
        PanelDerechosAutor panelDerechosAutor = new PanelDerechosAutor(this, informacion);
        vista.mostrarPanel(panelDerechosAutor);
    }
    public void guardarDatosMascota(String nombre, int edad, double peso, String color, boolean esterilizado) {
        modelo.savePetData(nombre, edad, peso, color, esterilizado);
    }
    public void actualizarDatosMascota(String nombreActual, String nuevoNombre, int nuevaEdad, double nuevoPeso, String nuevoColor, boolean nuevoEsterilizado) {
        modelo.actualizarDatosMascota(nombreActual, nuevoNombre, nuevaEdad, nuevoPeso, nuevoColor, nuevoEsterilizado);
    }
    public void eliminarDatosMascota(String nombre) {
        modelo.eliminarDatosMascota(nombre);
    }
}
