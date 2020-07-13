import sys

recipe = "{{\n  \"result\": {{\n    \"item\": \"luminaire:{lowMaterial}_{lowColor}\",\n    \"count\": 8\n  }},\n  \"pattern\": [\n    \"TTT\",\n    \"TDT\",\n    \"TTT\"\n  ],\n  \"type\": \"forge:ore_shaped\",\n  \"key\": {{\n    \"T\": {{\n      \"item\": \"#{capMaterial}\"\n    }},\n    \"D\": {{\n      \"item\": \"#{capColor}\"\n    }}\n  }}\n}}"
recipe_f = "./recipes/{lowMaterial}_{lowColor}.json"
torchTypes = ["basalt_torch", "bone_torch", "colored_flame", "jasper_torch", "marble_torch", "slate_torch", "bone_flame_chalice", "bone_orb_chalice", "gold_flame_chalice", "gold_orb_chalice", "shadow_flame_chalice", "shadow_orb_chalice", "silver_flame_chalice", "silver_orb_chalice"]
colors = ["white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black"]


for material in torchTypes:
    for color in colors:
        colorUpper = color.upper()
        materialUpper = material.upper()
        f = open(recipe_f.format(lowMaterial=material, lowColor=color), "w")
        f.write(recipe.format(lowMaterial=material, lowColor=color, capMaterial=materialUpper, capColor=colorUpper))
        f.close()