package ObjectClassMethods;
//finalize() Method in Java and How to Override it?
//The finalize() method in Java is called by the Garbage Collector
//just before object destroyed

//It allows the object to perform a clean-up activity.
// Clean-up activity means closing the resources associated with that object,
// like Database Connection,
// Network Connection or we can say resource de-allocation.

//Called only once per object by the Garbage Collector
//1. Object is getting destroyed
//Once GC decides an object is garbage,
// it will not bring it back again for cleanup repeatedly.
//
//2. No point in repeating cleanup
//After cleanup, object memory is released,
// so calling again is impossible.

//class Test{
    //Overrides method that is deprecated and marked for removal in 'java.lang.Object'
    //?In modern Java:
    //finalize() is deprecated
    //Not reliable (GC may not call it at all)
    //Replaced by:
    //try-with-resources
    //explicit cleanup
    //AutoCloseable

//    protected void finalize(){
//        System.out.println("cleanup before object deletion..");
//    }
//}

//public class FinalizeMethod {
//    public static void main(String[] args) {
//        Test t = new Test();
//        t = null;
//
//        System.gc();
//    }
//}
//GC cleans an object only once because after
// that the object no longer exists in memory.

//?-----------------------------------------------------4
//What is Finalization in Java?
//Just before destroying any object, the garbage collector
// always calls the finalize() method to perform clean-up activities on
// that object. This process is known as Finalization in Java. The Garbage collector
// calls the finalize() method only once on any object.

//Syntax of finalize()
//protected void finalize() throws Throwable
//
//Since the Object class contains the finalize method, hence finalize
// method is available for every Java class since Object is the superclass of
// all Java classes. Since it is available for every Java class, the Garbage
// Collector can call the finalize() method on any Java object.

//How to Override finalize() Method
//The finalize method, which is present in the Object class,
// has an empty implementation. In our class, clean-up activities
// are there. Then
// we have to override this method to define our clean-up activities.
//Example: Overriding finalize() Method

//    protected  void finalize() throws Throwable{



//2 Strong Reasons Why finalize() Was Deprecated
//1. Unreliable / No Guarantee
//
//There is no guarantee that finalize() will run at all or when it
// will run.
//So it cannot be trusted for important cleanup like closing
// files or DB connections.
//
//2. Performance Overhead
//
//Objects with finalize() become slower to garbage collect
// because they are moved to a special finalization queue,
// which delays memory recovery and reduces GC performance.

//?finalize() was deprecated because it is unreliable
// ?(no guaranteed execution)
// ?and causes performance overhead in garbage collection.

//Alternatives to finalize() (Modern Java Way):

//1. try-with-resources (BEST & MOST USED)
//Used for auto-closing resources like files, DB connections

//2. AutoCloseable Interface (Custom Resources)
//Used when you create your own resource class.

import java.io.FileInputStream;
import java.io.FileReader;

public class FinalizeMethod {
    public static void main(String[] args) {
        try(FileReader fr=new FileReader("C:\\Users\\DELL\\Desktop\\hangOut\\hangout.txt")){
            int data;
            while((data=fr.read())!=-1){
                System.out.println((char)data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}