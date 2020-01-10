package com.saugat.a4thassignmenthamro_bazzarreplica.bll;

import com.saugat.a4thassignmenthamro_bazzarreplica.api.UsersAPI;
import com.saugat.a4thassignmenthamro_bazzarreplica.serverresponse.SignUpResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Url;

public class LoginBLL {

    boolean isSuccess = false;

    public boolean checkUser(String email, String password) {

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> usersCall = usersAPI.checkUser(email, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                Url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
}
