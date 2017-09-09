package com.group1.booking.dao;

import java.util.ArrayList;
import com.group1.booking.models.Location;

public interface LocationDAO {
	public Location getLocationByCityCode(String cityCode);
	public String createLocation(Location location);
	public String updateLocation(Location location);
}
