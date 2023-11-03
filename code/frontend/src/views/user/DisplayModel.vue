<!--湖湘传统技艺类非物质文化遗产的具体作品赏析，3D模式多角度观察-->
<template>
  <div>
    <div>
      <div>
        <a-scene
            renderer="colorManagement: true;"
            info-message="htmlSrc: #messageText"
            model-viewer="gltfModel: #triceratops;">
          <a-assets>
            <!--
              Model source: https://sketchfab.com/3d-models/triceratops-d16aabe33dc24f8ab37e3df50c068265
              Model author: https://sketchfab.com/VapTor
              Model license: Sketcfab Standard
            -->
            <a-asset-item id="triceratops"
                          :src="modelUri"
                          response-type="arraybuffer" crossorigin="anonymous"></a-asset-item>

            <a-asset-item id="reticle"
                          src="https://cdn.aframe.io/examples/ar/models/reticle/reticle.gltf"
                          response-type="arraybuffer" crossorigin="anonymous"></a-asset-item>

            <img id="shadow" src="https://cdn.glitch.com/20600112-c04b-492c-8190-8a5ccc06f37d%2Fshadow.png?v=1606338852399">
            <a-asset-item id="messageText" src="message.html"></a-asset-item>
          </a-assets>
        </a-scene>
      </div>
      <el-button size="small" type="warning" @click="back"
                 style="position: absolute; left: 20px; top: 20px">返回</el-button>
    </div>
  </div>
</template>

<script>

export default {
  name: "DisplayModel",
  data() {
    return {

    }
  },
  computed: {
    modelUri() {
      return this.$store.state.modelUri
    }
  },
  methods: {
    back() {
      this.$router.back()
    }
  }
}
</script>

<style scoped>

</style>
