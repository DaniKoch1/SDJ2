package utility.collection;

import java.util.Scanner;

public class BoundedArrayStringQueueTEST
{
   public static void main(String[] args)
   {
      Scanner in=new Scanner(System.in);
      BoundedArrayStringQueue q=new BoundedArrayStringQueue(5);
      String text;
      boolean end=true;
      while(end)
      {
         System.out.println("To add an element type 1,\n"
               + "To delete an element type 2,\n"
               + "To get the first element type 3,\n"
               + "To get the index of an element type 4,\n"
               + "To get the size of the queue type 5,\n"
               + "To get an overview of the full queue type 6,\n"
               + "To end type 0.\n");
         int choice=in.nextInt();
         in.nextLine();
         switch(choice)
         {
            case 0:
               end=!end;
               break;
            case 1:
               System.out.println("Input the text you want to add to the queue.");
               text=in.nextLine();
               q.enqueue(text);
               break;
            case 2:
               System.out.println("The deleted element is "+q.dequeue());
               break;
            case 3:
               System.out.println("The first element of the queue is "+q.first());
               break;
            case 4:
               System.out.println("Input the element you want to find: ");
               text=in.nextLine();
               System.out.println("It's index is "+q.indexOf(text));
               break;
            case 5:
               System.out.println("The size of the queue is "+q.size());
               break;
            case 6:
               System.out.println(q.toString());
               break;
            default:
               System.out.println("Try again :(");
         }
         
      }
      
   }
}
