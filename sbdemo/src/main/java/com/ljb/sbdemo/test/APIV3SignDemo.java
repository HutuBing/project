package com.ljb.sbdemo.test;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.faceid.v20180301.FaceidClient;

import com.tencentcloudapi.faceid.v20180301.models.LivenessCompareRequest;
import com.tencentcloudapi.faceid.v20180301.models.LivenessCompareResponse;
public class APIV3SignDemo {
    public static void main(String [] args) {
        long startTime = System.currentTimeMillis();
        try{
            System.out.println("0");
            Credential cred = new Credential("AKIDtYy94kLvPdbJlyjc9RTHq8AwSn24capr", "yqS8kGasxzR0LWTFoCUFQQBndJsGRPCk");
            System.out.println("1");
            HttpProfile httpProfile = new HttpProfile();
            System.out.println("2");
            httpProfile.setEndpoint("faceid.tencentcloudapi.com");
            System.out.println("3");

            ClientProfile clientProfile = new ClientProfile();
            System.out.println("4");
            clientProfile.setHttpProfile(httpProfile);
            System.out.println("5");
            FaceidClient client = new FaceidClient(cred, "ap-guangzhou", clientProfile);
            System.out.println("6");
            String params = "{\"ImageBase64\":\""+Base64Test.base64(1)+"\",\"VideoBase64\":\""+Base64Test.base64(0)+"\",\"LivenessType\":\"SILENT\"}";
            LivenessCompareRequest req = LivenessCompareRequest.fromJsonString(params, LivenessCompareRequest.class);
            LivenessCompareResponse resp = client.LivenessCompare(req);

            System.out.println(LivenessCompareRequest.toJsonString(resp));
            long endTime = System.currentTimeMillis();
            System.out.println("时间："+ (endTime - startTime)/1000 + "秒");
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            long endTime = System.currentTimeMillis();
            System.out.println("时间："+ (endTime - startTime)/1000 + "秒");
        }

    }
}
