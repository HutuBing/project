package com.ljb.sbdemo.test;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.faceid.v20180301.FaceidClient;
import com.tencentcloudapi.faceid.v20180301.models.LivenessCompareRequest;
import com.tencentcloudapi.faceid.v20180301.models.LivenessCompareResponse;

public class LivenessCompare {
    public static void main(String [] args) {
        long startTime = System.currentTimeMillis();
        try {
            Credential cred = new Credential("AKIDtYy94kLvPdbJlyjc9RTHq8AwSn24capr", "yqS8kGasxzR0LWTFoCUFQQBndJsGRPCk");
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("faceid.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            FaceidClient client = new FaceidClient(cred, "ap-guangzhou", clientProfile);
            String params = "{\"ImageBase64\":\"" + Base64Test.base64(1) + "\",\"VideoBase64\":\"" + Base64Test.base64(0) + "\",\"LivenessType\":\"SILENT\"}";
            LivenessCompareRequest req = LivenessCompareRequest.fromJsonString(params, LivenessCompareRequest.class);
            LivenessCompareResponse resp = client.LivenessCompare(req);

            System.out.println(LivenessCompareRequest.toJsonString(resp));
            long endTime = System.currentTimeMillis();
            System.out.println("时间：" + (endTime - startTime) / 1000 + "秒");
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            long endTime = System.currentTimeMillis();
            System.out.println("时间：" + (endTime - startTime) / 1000 + "秒");
        }
    }
}
