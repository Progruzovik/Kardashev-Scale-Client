import { Gun, Hull, ShipData } from "./util";
import * as druid from "pixi-druid";
import * as PIXI from "pixi.js";

export class Ship implements ShipData {

    private _strength: number;

    readonly hull: Hull;
    readonly firstGun: Gun;
    readonly secondGun: Gun;

    constructor(data: ShipData) {
        this._strength = data.strength;
        this.hull = data.hull;
        this.firstGun = data.firstGun;
        this.secondGun = data.secondGun;
    }

    get strength(): number {
        return this._strength;
    }

    set strength(value: number) {
        if (value < 0) {
            this._strength = 0;
        } else if (value > this.hull.strength) {
            this._strength = this.hull.strength;
        } else {
            this._strength = value;
        }
    }

    get guns(): Gun[] {
        const result: Gun[] = [];
        if (this.firstGun) {
            result.push(this.firstGun);
        }
        if (this.secondGun) {
            result.push(this.secondGun);
        }
        return result;
    }

    createSprite(): PIXI.Sprite {
        const textureName: string = this.strength == 0 && this.hull.width == 1 && this.hull.height == 1
            ? "hull-1-destroyed" : this.hull.texture.name;
        const sprite = new PIXI.Sprite(PIXI.loader.resources[textureName].texture);
        if (this.strength == 0 && (this.hull.width != 1 || this.hull.height != 1)) {
            sprite.alpha = 0.5;
        }
        return sprite;
    }

    createStrengthBar(width: number, height: number = 15, color: number = 0xff0000): druid.ProgressBar {
        const bar = new druid.ProgressBar(width, height, color, druid.BarTextConfig.Default, this.hull.strength);
        bar.value = this.strength;
        return bar;
    }
}
