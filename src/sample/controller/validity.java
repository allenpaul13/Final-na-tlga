package sample.controller;

import java.util.regex.*;

public class validity {

    private int node = 0;
    private String subNodeOf5 = "false", subNodeOf6 = "false", subNodeOf7 = "false", aStart = "false", bStart = "false",
            bodyLoopA = "false", bodyLoopB = "false", zeroStart = "false", oneStart = "false",
            bodyLoopZero = "false", bodyLoopOne = "false", zeroStart2 = "false", oneStart2 = "false";
    private boolean validChecker1 = false, validChecker2 = false, validChecker3 = false, validChecker4 = false;
    private String finishedChecking1 ="false" , finishedChecking2 = "false" , finishedChecking3 = "false" , finishedChecking4 = "false";


    public String UserInputProcessor(String inputText){
        String input = inputText;
        input = input.replaceAll("\\s", "");
        System.out.println("new String is " + input);
        String[] inputArray = input.split("");

        if(input.contains("a")|| input.contains("b")){
            RegexEquation1(inputArray,input);
        }
        else{
            RegexEquation2(inputArray,input);
        }

        return input;
    }

    public void RegexEquation1(String[] userInput, String inputString){

        boolean matchFound;
        this.node = 0;

        String inputStringForm = "";
        String[] input = userInput;

        String elem = "";



        for(int i=0; i< input.length; i++){
            elem = input[i];
            inputStringForm+=elem;


            if(matchFound = Pattern.matches("a", inputStringForm) && i == 0){
                System.out.println("Invalid! String must not start with 'a' ");
                DFAequation1(inputStringForm);
                break;
            }
            this.node+=1;
            System.out.println("node is " + this.node);
            DFAequation1(inputStringForm);
            //tempArray.equals(validationOne.get(0))

            if(matchFound = Pattern.matches("bab|bbb", inputStringForm) && this.finishedChecking1 == "false"){
                System.out.println("I entered valid 1");
                this.validChecker1 = true;
                this.finishedChecking1 = "true";
                inputStringForm = "";

            }

            if((matchFound = Pattern.matches("[a-z]*aba", inputStringForm) && this.validChecker1) && this.finishedChecking2 == "false"){
                System.out.println("I entered valid 2");
                this.validChecker2 = true;
                this.finishedChecking2 = "true";
                inputStringForm = "";

            }

            if((matchFound = Pattern.matches("[a-z]*bb", inputStringForm) && this.validChecker2) && this.finishedChecking3 == "false"){
                System.out.println("I entered valid 3");
                this.validChecker3 = true;
                this.finishedChecking3 = "true";
                inputStringForm = "";

            }

            if((matchFound = Pattern.matches("[a-z]*bab|[a-z]*aba", inputStringForm) && this.validChecker3) && this.finishedChecking4 == "false" ){
                System.out.println("I entered valid 4");
                this.validChecker4 = true;
                this.finishedChecking4 = "true";

            }

        }

        if(this.validChecker4){
            System.out.println("The string You have inputted is VALID for question 1");
        }
        else{
            System.out.println("String is INVALID for question 1");
        }

    }

    public void RegexEquation2(String[] userInput, String inputString){

        boolean matchFound;

        String inputStringForm = "";
        String[] input = userInput;
        String elem = "";

        for(int i=0; i< input.length; i++){

            elem = input[i];
            inputStringForm+=elem;
            System.out.println("String is: " +inputStringForm);

            this.node+=1;
            System.out.println("node is " + this.node);
            DFAequation2(inputStringForm);

            if(matchFound = Pattern.matches("[0-9]*101|[0-9]*01|[0-9]*000", inputStringForm) && this.finishedChecking1 == "false"){
                System.out.println("I entered valid 1");
                this.validChecker1 = true;
                this.finishedChecking1 = "true";
                inputStringForm = "";
            }
            if((matchFound = Pattern.matches("[0-9]*111|[0-9]*00|[0-9]*101", inputStringForm) && this.validChecker1) && this.finishedChecking2 == "false"){
                System.out.println("I entered valid 2");
                this.validChecker2 = true;
                this.finishedChecking2 = "true";
                inputStringForm = "";
            }
        }

        if(this.validChecker2){
            System.out.println("The string You have inputted is VALID for question 2");
        }
        else{
            System.out.println("String is INVALID for question 2");
        }


    }

    public void DFAequation1(String input){
        boolean matchFound;
        System.out.println("I entered DFAequation1");
        System.out.println("String is " + input);

        if(this.finishedChecking1 == "false"){
            System.out.println("Entered Constant 1");
            if(this.node == 0){
                System.out.println("I entered trap statement, invalid");
            }
            else if(matchFound = Pattern.matches("b", input) && this.node == 1){
                System.out.println("entered node 1");
            }
            else if(matchFound = Pattern.matches("[a-z]*b|[a-z]*a", input) && this.node == 2){
                System.out.println("entered node 2");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 3){
                System.out.println("entered node 3");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 3){
                this.node-=2; //doesnt really matter
                System.out.println("I entered trap statement, invalid");
            }


        }

        else if((this.finishedChecking2 == "false" && this.subNodeOf5 == "false") || this.node == 7){
            System.out.println("Entered constant 2");
            if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 4){
                this.node-=1;
                System.out.println("I re-entered node 3, self loop");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 4){
                System.out.println("entered node 4");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 5){
                this.node-=1;
                System.out.println("I re-entered node 4, self loop");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 5){
                System.out.println("I re-entered node 5");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 6){
                this.subNodeOf5 = "true";
                System.out.println("entering subNodeOf5, subNodeOf5 value is now true");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 6){
                System.out.println("entered node 6");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 7){
                this.subNodeOf6 = "true";
                System.out.println("entering subNodeOf6, subNodeOf6 value is now true");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 7){
                System.out.println("entered node 7");
            }






        }

        else if((this.finishedChecking3 == "false" && this.subNodeOf6 == "false") || this.node == 8){
            System.out.println("Entered constant 3");
            if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 8){
                this.subNodeOf7 = "true";
                System.out.println("entering subnode of 7, subNodeOf7 is now true");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 8){
                System.out.println("entered node 8");
            }

        }

        else if((this.finishedChecking4 == "false" && this.subNodeOf7 == "false") || this.node == 11){
            System.out.println("Entered constant 4");
            if((matchFound = Pattern.matches("[a-z]*a", input) && this.node == 9) && this.bStart == "false"){
                this.aStart = "true";
                System.out.println("entered node 9 of a start and aStart is now true");
            }
            if(this.aStart == "true"){
                if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 10){
                    this.node-= 1;
                    System.out.println("I re-entered node 9");
                }
                else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 10){
                    System.out.println("entered node 10");
                }
                else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 11){
                    this.bodyLoopA = "true";
                    System.out.println("entered body loop for b letter, self loop A is now true");
                }
                else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 11){
                    System.out.println("entered final node of aStart");
                }
            }

            if((matchFound = Pattern.matches("[a-z]*b", input) && this.node == 9) && this.aStart == "false"){
                this.bStart = "true";
                System.out.println("entered node 9 of b start and bStart is now true");
            }
            if(this.bStart == "true"){
                if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 10){
                    this.node-=1;
                    System.out.println("I re-entered node 9");
                }
                else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 10){
                    System.out.println("I entered node 10");
                }
                else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 11){
                    this.bodyLoopB = "true";
                    System.out.println("entered body loop for a, bodyLoopB is now true");
                }
                else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 11){
                    System.out.println("entered final node of bStart");
                }

            }


        }

        if(this.subNodeOf5 == "true"){
            System.out.println("Entered subNodeOf5");
            if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 6){
                System.out.println("entered subnode of 5a");
            }
            else if(matchFound = Pattern.matches("[a-z]*b|[a-z]*a", input) && this.node == 7){
                this.node-=3;
                this.subNodeOf5= "false";
                System.out.println("I re-entered node 4");
            }
        }

        if(this.subNodeOf6 == "true"){
            System.out.println("entered subNodeOf6");
            if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 7){
                System.out.println("entered subnode of 6a");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 8){
                this.subNodeOf6 = "false";
                this.validChecker2 = false;
                this.finishedChecking2 = "false";
                this.node-=4;
                System.out.println("I re-entered subnode of 4");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 8){
                System.out.println("entered subnode of 6b");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 9){
                this.subNodeOf6 = "false";
                this.validChecker2 = false;
                this.finishedChecking2 = "false";
                this.node-=5;
                System.out.println("I re-entered node 4");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 9){
                this.node-=3;
                this.subNodeOf6 = "false";
                System.out.println("entered subnode of 6a");
            }
        }

        if(this.subNodeOf7 == "true"){
            System.out.println("entered subnode of 7");
            if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 8){
                System.out.println("entered subnode 7a");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 9){
                this.node-=3;
                System.out.println("I re-entered node 6");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 9){
                this.node-=5;
                this.subNodeOf7 = "false";
                this.validChecker2 = false;
                this.finishedChecking2 = "false";
                System.out.println("I re-entered node 4");
            }
        }

        if(this.bodyLoopA == "true"){
            System.out.println("entered bodyLoopA");
            if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 11){
                System.out.println("entered node 9 after body loop b letter");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 12){
                this.node-=1;
                System.out.println("entered node 9, self loop, after body loop b letter");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 12){
                System.out.println("entered node 10 after body loop b");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 13){
                this.node-=4;
                this.bodyLoopA = "false";
                System.out.println("entered node 9 after body loop a");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 13){
                System.out.println("entered final node from bodyLoopA");
            }
        }

        if(this.bodyLoopB == "true"){
            System.out.println("entered bodyLoopB");
            if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 11){
                System.out.println("entered node 9 after body loop a letter");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 12){
                this.node-=1;
                System.out.println("entered node 9 self loop after body loop a letter");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 12){
                System.out.println("entered node 10 after body loop a letter");
            }
            else if(matchFound = Pattern.matches("[a-z]*b", input) && this.node == 13){
                this.node-=4;
                this.bodyLoopB = "false";
                System.out.println("entered node 9 after body loop b");
            }
            else if(matchFound = Pattern.matches("[a-z]*a", input) && this.node == 12){
                System.out.println("entered final node from bodyLoopB");
            }
        }


    }

    public void DFAequation2(String input){
        boolean matchFound;
        System.out.println("I entered DFAequation2");
        System.out.println("String is " + input);

        if(this.finishedChecking1 == "false" || this.node == 3){
            System.out.println("constant 1");
            if(matchFound = Pattern.matches("0-9]*0", input) && this.node == 1){
                this.zeroStart = "true";
                System.out.println("entered node 1 zeroStart and zeroStart is now true");
            }
            if(this.zeroStart == "true"){
                if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 2){
                    this.node+=1;
                    System.out.println("entered node 3");
                }
                else if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 2){
                    System.out.println("entered node 2");
                }
                else if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 3){
                    System.out.println("entered node 3");
                }
                else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 3){
                    this.bodyLoopZero = "true";
                    System.out.println("bodyLoopZero is now true");
                }
            }

            if(matchFound = Pattern.matches("0-9]*1", input) && this.node == 1){
                this.oneStart = "true";
                System.out.println("entered node 1 oneStart and oneStart is now true");
            }
            if(this.oneStart == "true"){
                if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 2){
                    this.node-=1;
                    System.out.println("I re-entered node 1, self loop");
                }
                else if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 2){
                    this.bodyLoopOne = "true";
                    System.out.println("body loop one is now true");
                }
            }
        }

        else if(this.finishedChecking2 == "false"){
            System.out.println("constant 2");
            if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 4){
                this.zeroStart2 = "true";
                System.out.println("entered node 1 zeroStart2 and zeroStart2 is now true");
            }
            if(this.zeroStart2 == "true"){
                if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 5){
                    System.out.println("entered final node");
                }
                else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 5){
                    this.bodyLoopZero = "true";
                    System.out.println("bodyLoopZero is now true");
                }


            }

            if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 4){
                this.oneStart2 = "true";
                System.out.println("entered node 1 oneStart2 and oneStart 2 is now true");
            }
            if(this.oneStart2 == "true"){
                if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 5){
                    System.out.println("entered node 5");
                }
                else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 6){
                    System.out.println("entered final node");
                }
                else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 6){
                    this.node-=1;
                    System.out.println("I re-entered node 6, self loop");
                }
            }

        }

        if(this.bodyLoopZero == "true"){
            System.out.println("entered body loop of zero start");
            if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 3){
                System.out.println("entered node 1 after body loop of zeroStart");
            }
            else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 4){
                this.node-=1;
                System.out.println("I re-entered node 1 after body loop of zeroStart ");
            }
            else if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 4){
                this.node-=3;
                this.bodyLoopZero= "false";
                System.out.println("entered node 1 from bodyLoopZero");
            }
            else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 5){
                System.out.println("entered node 1 from bodyLoopZero");
            }
            else if(matchFound = Pattern.matches("[0-9]*1|[0-9]*0", input) && this.node == 6){
                System.out.println("entered node 2 from bodyLoopZero");
            }
            else if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 7){
                this.node-=1;
                System.out.println("I re-entered node 6, self loop from bodyLoopZero");
            }
            else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 7){
                this.node-=1;
                System.out.println("I entered final node from bodyLoopZero");
            }

        }
        if(this.bodyLoopOne == "true"){
            System.out.println("entered body loop of oneStart");
            if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 2){
                System.out.println("entered node 1 after body loop of oneStart");
            }
            else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 3){
                System.out.println("entered node 3 from bodyLoopOne");
            }
            else if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 3){
                System.out.println("entered node 2 from bodyLoopOne");
            }
            else if(matchFound = Pattern.matches("[0-9]*0", input) && this.node == 4){
                this.node-=1;
                System.out.println("entered node 3 from bodyLoopOne");
            }
            else if(matchFound = Pattern.matches("[0-9]*1", input) && this.node == 4){
                this.node-=1;
                this.bodyLoopOne = "false";
                System.out.println("entered node 3 from bodyLoopOne");
            }

        }
    }



}
