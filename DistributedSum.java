 import mpi.MPI;
 import mpi.MPIException;
 public class DistributedSum
 {
     public static void main(String[] args) throws MPIException
     {
         MPI.Init(args);
         int rank = MPI.COMM_WORLD.Rank();
//         System.out.println(rank);
         int size = MPI.COMM_WORLD.Size();
//         System.out.println(size);
         int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Input array
         int n = array.length;
         int localN = n / size; // Number of elements per processor
         int[] localArray = new int[localN]; // Local array for each processor
         int localSum = 0; // Local sum for each processor
         int totalSum = 0;
        
         // Scatter the input array to all processors
         MPI.COMM_WORLD.Scatter(array, 0, localN, MPI.INT, localArray, 0, localN, MPI.INT, 0);
        
         // Calculate the local sum for each processor
         for (int i = 0; i < localN; i++)
         {
             localSum += localArray[i];
         }
        
         // Send the local sum to the master processor
         int[] globalSum = new int[1];
         MPI.COMM_WORLD.Reduce(new int[] {localSum}, 0, globalSum, 0, 1, MPI.INT, MPI.SUM, 0);
        
         // Display the intermediate sums calculated by each processor
         System.out.println("Processor " + rank + " calculated sum = " + localSum);
        
         if (rank == 0) {
             totalSum = globalSum[0];
             System.out.println("Total Sum = " + totalSum);
         }
         MPI.Finalize();
     }
 }