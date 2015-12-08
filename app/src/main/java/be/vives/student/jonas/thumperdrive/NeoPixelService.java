package be.vives.student.jonas.thumperdrive;


import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Jonas on 23-11-2015.
 */
public interface NeoPixelService {
    @GET("neopixels/strings/{id}")
    Call<NeoPixelString> getNeoPixelStringInfo(@Path("id")String stringId);

    @POST("neopixels/strings/{id}")//pad naar de request van type post
    Call<StatusReport>setNeoPixelLedColor(@Path("id")String stringId,
                                           @Body NeoPixelColorEffect effect);//info die verstuurt wordt

    @POST("neopixels/effects/strobe/{id}")//pad naar de request van type post
    Call<StatusReport>setNeoPixelStrobe(@Path("id")String stringId,
                                           @Body NeoPixelStrobeEffect effect);//info die verstuurt wordt

}
