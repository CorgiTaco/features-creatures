package net.msrandom.featuresandcreatures.common.items.antler_headdress;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class AntlerHeadDressRenderer extends GeoArmorRenderer<AntlerHeadDressItem> {
    public AntlerHeadDressRenderer() {
        super(new AntlerHeadDressModel());
        this.headBone = "head";
        this.bodyBone = "body";
        this.rightArmBone = "rarm";
        this.leftArmBone = "larm";
        this.rightLegBone = "rleg";
        this.leftLegBone = "lleg";
        this.rightBootBone = "rboot";
        this.leftBootBone = "lboot";
    }
}
