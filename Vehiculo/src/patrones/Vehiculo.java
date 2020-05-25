package patrones;


public class Vehiculo
{
    private State estado; // Estado actual del vehiculo (apagado, parado, en marcha, sin combustible)
    private int velocidadActual = 0; // Velocidad actual del vehiculo
    private int combustibleActual = 0; // Cantidad de combustible restante


    public Vehiculo(int combustibleActual)
    {
        this.combustibleActual = combustibleActual;
        estado = new ApagadoState(this);
    }

    public Vehiculo(State estado)
    {
        this.estado = estado;
    }

    public void setEstado(State estado)
    {
        this.estado = estado;
    }

    public State getEstado()
    {
        return estado;
    }

    public void setVelocidadActual(int velocidadActual)
    {
        this.velocidadActual = velocidadActual;
    }

    public int getVelocidadActual()
    {
        return velocidadActual;
    }

    public void setCombustibleActual(int combustibleActual)
    {
        this.combustibleActual = combustibleActual;
    }

    public int getCombustibleActual()
    {
        return combustibleActual;
    }

    // Los metodos del contexto invocaran el metodo de la interfaz State, delegando las operaciones
    // dependientes del estado en las clases que los implementen.
    public void Acelerar()
    {
        estado.Acelerar();
        System.out.println("Velocidad actual: " + velocidadActual + ". Combustible restante: " + combustibleActual);
    }

    public void Frenar()
    {
        estado.Frenar();
    }

    public void Contacto()
    {
        estado.Contacto();
    }

    public void ModificarVelocidad(int kmh)
    {
        velocidadActual += kmh;
    }

    public void ModificarCombustible(int decilitros)
    {
        combustibleActual += decilitros;
    }

}
