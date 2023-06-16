package Payment;

// pay for service by cash

public class CacheOnDelivery implements Payment
{
    public void pay (double price)
    {
    	System.out.println("Price that should pay with cash = "+price);
    };
    
}
