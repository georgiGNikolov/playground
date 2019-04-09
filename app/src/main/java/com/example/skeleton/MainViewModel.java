package com.example.skeleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Response> liveData = new MutableLiveData<>();
    private Service service = new Service();

    public void makeNetworkCall() {
        service.getLiveData().observeForever(response ->  {
            liveData.setValue(response);
        });
        service.getInfo("georgiGNikolov");
    }

    public LiveData<Response> getLiveData() {
        return liveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }
}
