package be.vives.student.jonas.thumperdrive;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Jonas on 1-12-2015.
 */
public interface ThumperService {
    @POST("speed")//pad naar de request van type post
    Call<ThumperStatusReport> setThumperSpeed(@Body SpeedEffect effect);//info die verstuurt wordt
}
