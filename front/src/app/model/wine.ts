export interface Wine {
  id: number;
  name: string;
  description: string
  estate: string;
  appellation: string;
  price: number;
  alcoholPercentage: number;
  region: string;
  year: string;
  color: string;
  grapeVarieties: {
    name: string;
    percentage: number;
  }
}

/**
 *private int id;
  private String name;
  private String estate;
  private String appellation;
  private String description;
  private float price;
  private float alcoholPercentage;
  private String region;
  private Year year;
  private String color;
  private List<GrapeVarietyDto> grapeVarieties;
 */
