package service;

import domain.Operation;

import java.util.List;

public class ServiceCalc {

    ServiceResult serviceResult = new ServiceResult();

    public double calculation(String operation, double num1, double num2) {
        double num3;
        switch (operation) {
            case ("plus"):
                num3 = num1 + num2;
                break;
            case ("minus"):
                num3 = num1 - num2;
                break;
            case ("div"):
                num3 = num1 / num2;
                break;
            case ("times"):
                num3 = num1 * num2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
        return num3;
    }

    public List calcResult(String operation, List <Operation> result) {

         switch (operation) {
             case ("all"):
                 return serviceResult.allResult(result);
             case ("plus"):
                return serviceResult.plusResult(result);
            case ("minus"):
                return serviceResult.minusResult(result);
            case ("div"):
                return serviceResult.divResult(result);
            case ("times"):
                return serviceResult.timesResult(result);
             default:
                 throw new IllegalStateException("Unexpected value: " + operation);
         }
    }




}
