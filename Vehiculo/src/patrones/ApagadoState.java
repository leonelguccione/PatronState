package patrones;

public class ApagadoState implements State
{
    private Vehiculo v;


    public ApagadoState(Vehiculo v)
    {
        this.v = v;
    }

    public void Acelerar()
        {
            // Acelerar con el vehiculo apagado no sirve de mucho <img draggable="false" role="img" class="emoji" alt="🙂" src="https://s0.wp.com/wp-content/mu-plugins/wpcom-smileys/twemoji/2/svg/1f642.svg" scale="0">
            System.out.println("ERROR: El vehiculo esta apagado. Efectue el contacto para iniciar");
        }
     
        public void Frenar()
        {
            // Frenar con el vehiculo parado tampoco sirve de mucho...
            System.out.println("ERROR: El vehiculo esta apagado. Efectue el contacto para iniciar");
        }
     
        public void Contacto()
        {
            // Comprobamos que el vehiculo disponga de combustible
            if (v.getCombustibleActual() > 0)
            {
                // El vehiculo arranca -> Cambio de estado
                //estado = PARADO;
                v.setEstado(new ParadoState(v));
                System.out.println("El vehiculo se encuentra ahora PARADO");
                v.setVelocidadActual(0);
            }
            else
            {
                // El vehiculo no arranca -> Sin combustible
                //estado = SIN COMBUSTIBLE
                v.setEstado(new SinCombustibleState(v));
                System.out.println("El vehiculo se encuentra sin combustible");
            }
        }
}
