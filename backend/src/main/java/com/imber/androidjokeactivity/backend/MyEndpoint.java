/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.imber.androidjokeactivity.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.imber.jokes.Jokes;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.androidjokeactivity.imber.com",
    ownerName = "backend.androidjokeactivity.imber.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "getJoke")
    public JokeWrapper getJoke() {
        Jokes jokes = new Jokes();
        JokeWrapper wrapper = new JokeWrapper();
        wrapper.setJoke(jokes.getJoke());
        return wrapper;
    }

}
