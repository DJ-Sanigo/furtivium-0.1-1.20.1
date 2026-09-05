package furtivium.Sculk.Minecraft.Mod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;



public class Broken1Model<T extends Broken1Model> extends SinglePartEntityModel<T> {
	private final ModelPart BrokenV1;
	private final ModelPart Head;
	private final ModelPart MainHead;
	private final ModelPart Tendrils;
	private final ModelPart Body;
	private final ModelPart Torse;
	private final ModelPart Spine;
	private final ModelPart Hip;
	private final ModelPart Arm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public Broken1Model(ModelPart root) {
		this.BrokenV1 = root.getChild("BrokenV1");
		this.Head = this.BrokenV1.getChild("Head");
		this.MainHead = this.Head.getChild("MainHead");
		this.Tendrils = this.Head.getChild("Tendrils");
		this.Body = this.BrokenV1.getChild("Body");
		this.Torse = this.Body.getChild("Torse");
		this.Spine = this.Body.getChild("Spine");
		this.Hip = this.Body.getChild("Hip");
		this.Arm = this.Body.getChild("Arm");
		this.RightLeg = this.BrokenV1.getChild("RightLeg");
		this.LeftLeg = this.BrokenV1.getChild("LeftLeg");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData BrokenV1 = modelPartData.addChild("BrokenV1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, 2.0F));

		ModelPartData Head = BrokenV1.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -7.0F, 1.0F));

		ModelPartData MainHead = Head.addChild("MainHead", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.0F, -3.0F, 8.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, -1.0F));

		ModelPartData Tendrils = Head.addChild("Tendrils", ModelPartBuilder.create().uv(0, 15).cuboid(-8.0F, -4.0F, 0.0F, 16.0F, 12.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Body = BrokenV1.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0F, -1.0F));

		ModelPartData Torse = Body.addChild("Torse", ModelPartBuilder.create().uv(0, 27).cuboid(-4.0F, -1.0F, -2.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 1.0F));

		ModelPartData Spine = Body.addChild("Spine", ModelPartBuilder.create().uv(0, 41).cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 14.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 1.0F));

		ModelPartData Hip = Body.addChild("Hip", ModelPartBuilder.create().uv(28, 27).cuboid(-3.0F, 0.0F, -2.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 9.0F, 1.0F));

		ModelPartData Arm = Body.addChild("Arm", ModelPartBuilder.create().uv(32, 0).cuboid(0.0F, 0.0F, -1.0F, 3.0F, 11.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 4.0F, 2.0F));

		ModelPartData RightLeg = BrokenV1.addChild("RightLeg", ModelPartBuilder.create().uv(32, 14).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 14.0F, 1.0F));

		ModelPartData LeftLeg = BrokenV1.addChild("LeftLeg", ModelPartBuilder.create().uv(40, 14).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 14.0F, 1.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(Broken1Model entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		BrokenV1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return BrokenV1;
	}

}