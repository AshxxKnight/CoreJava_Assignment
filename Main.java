import java.util.*;
class InvalidInputException extends Exception
{
    InvalidInputException(String str)
    {
        super(str);
    }
}
class Amount_calc{
    static double calculation(double amt, double tax, double price){
        double amount = 0.0;
        amount = (amt * price) ;
        amount += (amount * tax) ;
        return amount;
    }
}

class Insurance_type {
    static double Ins_type(double amt, String itype, double price) {
        try {
            if (itype.equalsIgnoreCase("premium"))
                return Amount_calc.calculation(amt, 0.20, price);
            else if (itype.equalsIgnoreCase("basic"))
                return Amount_calc.calculation(amt, 1, price);
            else
                throw new InvalidInputException("Please input correct Insurance type");
        } catch (Exception e) {
            System.out.println(e);
        }
    return 0;
    }
}
class carType{
    static double type(String ctype, double price , String itype) {
        try {
            if (ctype.equalsIgnoreCase("hatchback")) {
                return Insurance_type.Ins_type(0.05, itype, price);
            } else if (ctype.equalsIgnoreCase("suv")) {
                return Insurance_type.Ins_type(0.10, itype, price);
            } else if (ctype.equalsIgnoreCase("sedan")) {
                return Insurance_type.Ins_type(0.08, itype, price);
            } else {
                throw new InvalidInputException("Please input correct car type");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
class Display{
    static void print(String model, String ctype, double insurance_amt){
        System.out.println("Car model" + model + "\n" +"Car type" + ctype + "\n" +"Insurance to be paid" + insurance_amt);
    }
 }
class Insurance_amount{
    public static String model, ctype, itype;
    public static double price;
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        char ch;
        do{

            System.out.println("Enter car model");
            model = sc.next();
            System.out.println("Enter car type");
            ctype = sc.next();
            System.out.println("Enter car insurance type");
            itype = sc.next();
            System.out.println("Enter car price");
            price = sc.nextDouble();

            double amount = carType.type(ctype,price,itype);

//            Insurance_amount obj = new Insurance_amount();
            Display.print(model,ctype,amount);

            System.out.println("\n");
            ch = ' ';
            while(ch != 'Y' && ch != 'N')
            {
                try
                {
                    System.out.print("Wish to continue? (Y/N) ? ");
                    ch = sc.next().charAt(0);
                    ch = Character.toUpperCase(ch);

                    if(ch != 'Y' && ch != 'N')
                    {
                        System.out.println(ch);
                        throw new InvalidInputException("Please input correct character");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);

                }
            }
        }while(ch != 'N');

    }
}