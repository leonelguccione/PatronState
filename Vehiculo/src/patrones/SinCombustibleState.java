package patrones;


public class SinCombustibleState implements State
{
    // Referencia a la clase de contexto
        private Vehiculo v;
     
        // Constructor que inyecta la dependencia en la clase actual
        public SinCombustibleState(Vehiculo v)
        {
            this.v = v;
        }
     
        public void Acelerar()
        {
            System.out.println("ERROR: El vehiculo se encuentra sin combustible");
        }
     
        public void Frenar()
        {
            System.out.println("ERROR: El vehiculo se encuentra sin combustible");
        }
     
        public void Contacto()
        {
            System.out.println("ERROR: El vehiculo se encuentra sin combustible");
        }
}
