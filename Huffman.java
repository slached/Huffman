public class Huffman {

    //I'm student,my code may have some small mistakes please be nice to me :)

    //integer arrays
    int[] array = new int[255];
    int[] arrayOf3 = new int[255];
    int[] copyOfarrayOf3 = new int[255];
    int[] copyOfarray;

    //integers
    int getHowManyElementInArray;
    int getValuableLenOfWholeArray;
    int getGetValuableLenOfWholeArrayButString;
    int getValueableElementOfArray3;

    //string arrays
    String[] wholeArrayButWithString = new String[255];

    //strings
    String invertedBinary = "";
    String binary = "";

    public static void main(String[] args) {

        new Huffman().run();

    }

    void run() {
        addAllElements();
        doHuffman();
        printBinary();
    }

    void addAllElements() {
        //this function is for add element
        array[0] = 6;
        array[1] = 3;
        array[2] = 12;
        array[3] = 51;
        array[4] = 2;
        array[5] = 13;

    }

    void sort(int[] arrays) {
        //sorting to ascending
        for (int i = 0; i < arrays.length; i++) {

            for (int j = i; j < arrays.length; j++) {

                if (arrays[i] > arrays[j] && arrays[i] != 0 && arrays[j] != 0) swapElements(i, j, arrays);

            }
        }

    }

    void swapElements(int firstIndex, int secondIndex, int[] arrays) {
        //this is for swaping array elements
        int temp = arrays[firstIndex];
        arrays[firstIndex] = arrays[secondIndex];
        arrays[secondIndex] = temp;

    }

    void slideForArray(int times, int[] arrays) {
        //this is sliding 0's to right side of array
        while (times > 0) {

            for (int i = 1; i < arrays.length; i++) if (arrays[i] != 0) swapElements(i, i - 1, arrays);

            times--;
        }
    }

    void seeArray(int[] arrays) {
        //this is for see array elements
        String array = "";

        for (int i : arrays) if (i != 0) array += i + ", ";

        System.out.print("[ ");
        System.out.print(array.substring(0, array.length() - 2));
        System.out.println(" ]");

    }

    void seeArrayForStrings(String[] arrays) {
        //this is for see array elements
        String array = "";

        for (String i : arrays) if (i != null) array += i + ", ";

        System.out.print("[ ");
        System.out.print(array.substring(0, array.length() - 2));
        System.out.println(" ]");

    }

    void doHuffman() {
        //this function is summation of to lowest element of array. deleting two lowest element and after
        //adding into array summation of this lowest numbers and do this loop till array is whole 0's.

        sort(array);
        for (int i : array) if (i != 0) getHowManyElementInArray++;

        copyOfarray = new int[getHowManyElementInArray];

        for (int i = 0; i < getHowManyElementInArray; i++) copyOfarray[i] = array[i]; //array copy to wholeArray

        for (int i = 0; i < getHowManyElementInArray - 1; i++) { //wholeArrayButWithString is not working as huffman study huffman and try again
            array[50] = array[0] + array[1];
            wholeArrayButWithString[i] = array[50] + "l" + array[0] + "r" + array[1];
            array[0] = 0;
            array[1] = 0;
            slideForArray(50, array);
            sort(array);

        }

        createArrayOf3();

    }

    void createArrayOf3() {
        //this function is creating arrayof3
        //what is array of 3? array of 3 is a structure like [main node1,left node1,right node1,main node2,left node2,right node2,..]
        //but left side is highest elements and right side is lowest this provides us to find binary explanation of array
        for (String i : wholeArrayButWithString) if (i != null) getGetValuableLenOfWholeArrayButString++;

        int left;
        int right;
        int mainNode;
        int a = 0;

        String leftS = "";
        String rightS = "";
        String mainNodeS = "";

        for (int i = getGetValuableLenOfWholeArrayButString - 1; i >= 0; i--) { //select whole string from last index

            for (int j = 0; j < wholeArrayButWithString[i].length() /*string size of specified string*/ ; j++) {// select in string

                if (wholeArrayButWithString[i].charAt(j) == 'l') { // for find left and right
                    // 'l' at j then till 'r' is number

                    int tempJ = j + 1; // location of l (3)
                    int tempJ2 = 0;//location of r (6)

                    for (int l = 0; l < wholeArrayButWithString[i].length(); l++)
                        if (wholeArrayButWithString[i].charAt(l) == 'r') tempJ2 = l; // find r's location

                    int tempJ3 = tempJ2 + 1; //clone of where r is

                    while (tempJ3 < wholeArrayButWithString[i].length()) {
                        rightS += wholeArrayButWithString[i].charAt(tempJ3);
                        tempJ3++;
                    }

                    while (tempJ2 > tempJ) {//number is between tempj and tempj2

                        leftS += wholeArrayButWithString[i].charAt(tempJ);
                        tempJ++;
                    }

                    int tillFirstNumber = j - 1; // location of l but -1

                    for (int p = 0; p <= tillFirstNumber; p++) { //this found main node
                        mainNodeS += wholeArrayButWithString[i].charAt(p);
                    }
                }
            }

            //you are in first for so this for is selecting wholeArrayButStrings elements (168l63r105)

            left = Integer.parseInt(leftS);
            right = Integer.parseInt(rightS);
            mainNode = Integer.parseInt(mainNodeS);

            leftS = "";
            rightS = "";
            mainNodeS = "";

            arrayOf3[a++] = mainNode;
            arrayOf3[a++] = left;
            arrayOf3[a++] = right;

        } // this is creating array3

    }

    void createBinary(int select) {

        // note array3's 0 3 6 9 and times of 3 is main nodes
        // 1 3 5 7 and so 2n+1 s are left node
        // 2 4 6 8 and so 2n s are right node

        //in this function im going to explain with example
        //[102,52,50,31,10,11...] this is array of 3 structure this function is working recursively first step finding select parameter
        //select parameter is which leaf node do you looking for for example if you want to get 11's binary explanation this function is
        //trying to find 11 in array of 3 if it find its find is 11 left or right and giving binary provision to 11 and looking for
        //what is 11' main node and after finding main node of 11 now this function is searching is 11'main node as leaf node
        //this function is working till array of 3 is emphty
        //also after find binary provision of 11 we need to delete rest of the array of 3 till 11's main node

        int indexOfMainNode = 0;
        int left = 0;
        int right = 0;
        int nodeOfMain = 0;

        //this code is selecting 3 piece of array3 and pairing left is left right is right and main node is nodeOfMain after doing that
        //deleting rest of array3

        if (select == copyOfarrayOf3[1] || select == copyOfarrayOf3[2]) { //if selected item in first 3 box (end of recursion)
            //this will terminate and recursion will be end

            if (select == copyOfarrayOf3[1]) binary += 0;
            if (select == copyOfarrayOf3[2]) binary += 1;

            int goTill = 0;
            while (goTill < 25) { //this will delete entire right sides of elements
                copyOfarrayOf3[indexOfMainNode] = 0;
                indexOfMainNode++;
                goTill++;
            }

        } else {

            for (int i = 0; i < 255; i++) {//to find root node and index

                if (i != 3 * i) {

                    if (select == copyOfarrayOf3[i]) {

                        if (copyOfarrayOf3[i] + copyOfarrayOf3[i + 1] == copyOfarrayOf3[i - 1]) {//left
                            indexOfMainNode = i - 1;
                            nodeOfMain = copyOfarrayOf3[i - 1];
                        } else if (copyOfarrayOf3[i] + copyOfarrayOf3[i - 1] == copyOfarrayOf3[i - 2]) {//right
                            indexOfMainNode = i - 2;
                            nodeOfMain = copyOfarrayOf3[i - 2];
                        }
                    }
                }
            }


            for (int i = 0; i < 255; i++) {

                if (i == indexOfMainNode) {
                    left = copyOfarrayOf3[i + 1];
                    right = copyOfarrayOf3[i + 2];

                    int goTill = 0;
                    while (goTill < 25) { //this will delete entire right sides of elements
                        copyOfarrayOf3[i++] = 0;
                        goTill++;
                    }

                }

                if (select == left) {
                    binary += 0;
                    break;//for break
                } else if (select == right) {
                    binary += 1;
                    break;//for break
                }

            }

        }

        getValueableElementOfArray3 = 0;
        for (int i = 0; i < 255; i++) if (copyOfarrayOf3[i] != 0) getValueableElementOfArray3++;
        if (getValueableElementOfArray3 != 0) createBinary(nodeOfMain);

    }

    void copyAgain() {
        //this is copying arrayof3
        for (int i = 0; i < 255; i++) copyOfarrayOf3[i] = arrayOf3[i];

    }

    void doInvert() {
        //this is binary invert
        int lastIndex = binary.length() - 1;
        for (int i = lastIndex; i >= 0; i--) invertedBinary += binary.charAt(i);
    }

    void printBinary() {
        //this is last function that make us to see the result
        System.out.println(" Huffman to binary");
        System.out.print("====================\n");

        for (int i = 0; i < getHowManyElementInArray; i++) {

            binary = "";
            invertedBinary = "";

            copyAgain();//copy array
            createBinary(copyOfarray[i]);
            doInvert();

            System.out.println("    " + copyOfarray[i] + " --> " + invertedBinary);


        }
    }
}