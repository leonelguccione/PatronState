package patrones;

public class EnMarchaState implements State
{
    private final int VELOCIDAD_MAXIMA = 200;
     
            // Referencia a la clase de contexto
            private Vehiculo v;
     
            // Constructor que inyecta la dependencia en la clase actual
            public EnMarchaState(Vehiculo v)
            {
                this.v = v;
            }
     
            public void Acelerar()
            {
                if (v.getCombustibleActual() > 0)
                {
                    // Aumentamos la velocidad, permaneciendo en el mismo estado
                    if (v.getVelocidadActual() >= VELOCIDAD_MAXIMA)
                    {
                        System.out.println("ERROR: El coche ha alcanzado su velocidad maxima");
                        v.ModificarCombustible(-10);
                    }
                    else
                    {
                        v.ModificarVelocidad(10);
                        v.ModificarCombustible(-10);
                    }
                }
                else
                {
                    //estado = SIN COMBUSTIBLE
                    v.setEstado(new SinCombustibleState(v));
                    System.out.println("El vehiculo se ha quedado sin combustible");
                }
            }
     
            public void Frenar()
            {
                // Reducimos la velocidad. Si esta llega a 0, cambiaremos a estado "PARADO"
                v.ModificarVelocidad(-10);
                if (v.getVelocidadActual() <= 0)
                {
                    //estado = PARADO;
                    v.setEstado( new ParadoState(v));
                    System.out.println("El vehiculo se encuentra ahora PARADO");
                }
            }
     
            public void Contacto()
            {
                // No se puede detener el vehiculo en marcha!
                System.out.println("ERROR: No se puede cortar el contacto en marcha!");
            }
}
