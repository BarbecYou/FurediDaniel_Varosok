package hu.home.varosok;

import android.os.AsyncTask;

import java.io.IOException;

import hu.home.varosok.databinding.ActivityListBinding;

public class RequestTask extends AsyncTask<Void, Void, Response> {

    private String requestUrl;
    private String requestMethod;
    private String requestBody;

    public RequestTask(String requestUrl, String getRequestMethod, String requestBody) {
        this.requestUrl = requestUrl;
        this.requestMethod = getRequestMethod;
        this.requestBody = requestBody;
    }

    public RequestTask(String requestUrl) {
        this.requestUrl = requestUrl;
        this.requestMethod = "GET";
    }

    public RequestTask(String requestUrl, String requestMethod) {
        this.requestUrl = requestUrl;
        this.requestMethod = requestMethod;
    }

    @Override
    protected Response doInBackground(Void... voids) {
        Response response = null;
        try {
            switch (requestMethod){
                case "GET":
                    response = RequestHandler.get(requestUrl);
                    break;
                case "POST":
                    response = RequestHandler.post(requestUrl, requestBody);
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Response response) {
        String data = response.getContent();

        switch (requestMethod){
            case "GET":
                ListActivity.binding.listDataTextView.setText(data);
                break;
            case "POST":

                break;
        }
    }
}
