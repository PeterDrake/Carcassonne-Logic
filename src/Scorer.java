public class Scorer {
	public boolean isRoadComplete(Tile tile) {
		
		// check if placed tile has a ROAD or ROAD_END
		if (!tile.contains(Tile.ROAD) || !tile.contains(Tile.ROAD_END)) {
			return false;
		}
		
		// if tile has ROAD_END use a depth-first search to find another ROAD_END
		if (tile.contains(Tile.ROAD_END)) {
			
		}

		
		return false;	
	}
}