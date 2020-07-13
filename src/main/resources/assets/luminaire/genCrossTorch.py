import sys

blockstate = "{{\n  \"forge_marker\": 1,\n  \"defaults\": {{\n    \"transform\": \"forge:default-item\",\n    \"model\": \"cross\",\n    \"textures\": {{\n      \"cross\": \"luminaire:blocks/{name}\",      \"particle\": \"#cross\"\n    }}\n  }},\n  \"variants\": {{\n    \"facing\": {{\n      \"up\": {{ \"model\": \"cross\" }},\n      \"east\": {{ \"model\": \"luminaire:cross_wall\" }},\n      \"south\": {{ \"model\": \"luminaire:cross_wall\", \"y\": 90 }},\n      \"west\": {{ \"model\": \"luminaire:cross_wall\", \"y\": 180 }},\n      \"north\": {{ \"model\": \"luminaire:cross_wall\", \"y\": 270 }}\n    }}\n  }}\n}}"
#model = "{{\n  \\"parent\\": \\"block/cube_all\\",\n  \\"textures\\": {{\n    \\"all\\": \\"luminaire:blocks/{name}\\"\n  }}\n}}"
item_model = "{{\n  \"parent\": \"item/generated\",\n  \"textures\": {{\n    \"layer0\": \"luminaire:blocks/{name}\"\n  }}\n}}"
blockstate_f = "./blockstates/{name}.json"
model_f = "./models/block/{name}.json"
item_model_f = "./models/item/{name}.json"
for string in sys.argv[1:]:
    f = open(blockstate_f.format(name=string), "w")
    f.write(blockstate.format(name=string))
    f.close()

#     f = open(model_f.format(name=string), "w")
#     f.write(model.format(name=string))
#     f.close()

    f = open(item_model_f.format(name=string), "w")
    f.write(item_model.format(name=string))
    f.close()


