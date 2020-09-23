package com.mycompany.app;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesRequest;

@SuppressWarnings("unused")
public class App implements RequestHandler<App.InputObject, String> {

    public String handleRequest(InputObject inputObject, Context context) {
        AmazonEC2 ec2Client = AmazonEC2ClientBuilder.standard()
                .withRegion("us-east-1")
                .build();
        String instanceId = "i-088a86bc4c9b0265c";
        StartInstancesRequest request = new StartInstancesRequest().withInstanceIds(instanceId);
        ec2Client.startInstances(request)
                .getStartingInstances()
                .get(0)
                .getPreviousState()
                .getName();
        System.out.println("Started the Instnace with ID: "+instanceId);
        return "{\"result\": \"hello lambda java\"}";
    }  

    public static class InputObject {
        private String key1;
        private String key2;
        private String key3;

        public String getKey1() {
            return key1;
        }

        public String getKey2() {
            return key2;
        }

        public String getKey3() {
            return key3;
        }

        public void setKey1(String key1) {
            this.key1 = key1;
        }

        public void setKey2(String key2) {
            this.key2 = key2;
        }

        public void setKey3(String key3) {
            this.key3 = key3;
        }

        @Override
        public String toString() {
            return "InputObject{" +
                    "key1='" + key1 + '\'' +
                    ", key2='" + key2 + '\'' +
                    ", key3='" + key3 + '\'' +
                    '}';
        }
    }
}