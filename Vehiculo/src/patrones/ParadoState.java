package patrones;

public class ParadoState implements State
{
    // Referencia a la clase de contexto
        private Vehiculo v;
     
        // Constructor que inyecta la dependencia en la clase actual
        public ParadoState(Vehiculo v)
        {
            this.v = v;
        }
     
        public void Acelerar()
        {
            // Comprobamos que el vehiculo disponga de combustible
            if (v.getCombustibleActual() > 0)
            {
                // El vehiculo se pone en marcha. Aumenta la velocidad y cambiamos de estado
                //estado = EN_MARCHA;
                v.setEstado( new EnMarchaState(v));
                System.out.println("El vehiculo se encuentra ahora EN MARCHA");
                v.ModificarVelocidad(10);
                v.ModificarCombustible(-10);
            }
            else
            {
                //estado = SIN COMBUSTIBLE
                v.setEstado(new SinCombustibleState(v));
                System.out.println("El vehiculo se encuentra ahora SIN COMBUSTIBLE");
            }
        }
     
        public void Frenar()
        {
            // No ocurre nada. Si el vehiculo ya se encuentra detenido, no habra efecto alguno
            System.out.println("ERROR: El vehiculo ya se encuentra detenido");
        }
     
        public void Contacto()
        {
            // El vehiculo se apaga
            // estado = APAGADO;
            v.setEstado(new ApagadoState(v));
            System.out.println("El vehiculo se encuentra ahora APAGADO");
        }
}
