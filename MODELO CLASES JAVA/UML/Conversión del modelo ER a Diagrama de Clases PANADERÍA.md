## [Conversión del modelo ER a Diagrama de Clases](<img width="834" alt="Conversión del modelo ER a Diagrama de Clasespng" src="https://github.com/user-attachments/assets/6561e0c4-9b70-4b09-b868-a0a4ad14a910" />)



{
	"_type": "Project",
	"_id": "AAAAAAFF+h6SjaM2Hec=",
	"name": "Untitled",
	"ownedElements": [
		{
			"_type": "UMLModel",
			"_id": "AAAAAAFF+qBWK6M3Z8Y=",
			"_parent": {
				"$ref": "AAAAAAFF+h6SjaM2Hec="
			},
			"name": "Model",
			"ownedElements": [
				{
					"_type": "UMLClassDiagram",
					"_id": "AAAAAAFF+qBtyKM79qY=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Main",
					"defaultDiagram": true,
					"ownedViews": [
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTl7ozsTkdb9k=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTl7ozsjkex0Y=",
									"_parent": {
										"$ref": "AAAAAAGTl7ozsTkdb9k="
									},
									"model": {
										"$ref": "AAAAAAGTl7ozsTkbeEA="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7ozsjkf+iw=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkex0Y="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -148.453125,
											"top": -380,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7ozsjkgxRE=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkex0Y="
											},
											"font": "Arial;13;3",
											"parentStyle": true,
											"left": 789,
											"top": 471,
											"width": 226.10693359375,
											"height": 13,
											"text": "Producto"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7ozsjkhjkM=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkex0Y="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -148.453125,
											"top": -380,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7ozsjkiSgE=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkex0Y="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -148.453125,
											"top": -380,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 784,
									"top": 464,
									"width": 236.10693359375,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTl7ozsjkf+iw="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTl7ozsjkgxRE="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTl7ozsjkhjkM="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTl7ozsjkiSgE="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTl7ozsjkjES4=",
									"_parent": {
										"$ref": "AAAAAAGTl7ozsTkdb9k="
									},
									"model": {
										"$ref": "AAAAAAGTl7ozsTkbeEA="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7pxLTlIZjM=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkjES4="
											},
											"model": {
												"$ref": "AAAAAAGTl7pxKTlFs+E="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 789,
											"top": 494,
											"width": 226.10693359375,
											"height": 13,
											"text": "-codigo: int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7quZDlPwuM=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkjES4="
											},
											"model": {
												"$ref": "AAAAAAGTl7quYTlMMdk="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 789,
											"top": 509,
											"width": 226.10693359375,
											"height": 13,
											"text": "-nombre: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7sDrTlW8cA=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkjES4="
											},
											"model": {
												"$ref": "AAAAAAGTl7sDqjlTAkI="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 789,
											"top": 524,
											"width": 226.10693359375,
											"height": 13,
											"text": "-tipo: enum",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7tXGzlhEc4=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkjES4="
											},
											"model": {
												"$ref": "AAAAAAGTl7tXGDlem+c="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 789,
											"top": 539,
											"width": 226.10693359375,
											"height": 13,
											"text": "-precio: double",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 784,
									"top": 489,
									"width": 236.10693359375,
									"height": 68
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTl7ozsjkk3vg=",
									"_parent": {
										"$ref": "AAAAAAGTl7ozsTkdb9k="
									},
									"model": {
										"$ref": "AAAAAAGTl7ozsTkbeEA="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFl7gz30SXc=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkk3vg="
											},
											"model": {
												"$ref": "AAAAAAGTmFl7fj3xe4A="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 789,
											"top": 562,
											"width": 226.10693359375,
											"height": 13,
											"text": "+calcularImpuesto(): double",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFnWyz3+39Y=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkk3vg="
											},
											"model": {
												"$ref": "AAAAAAGTmFnWxz37xBE="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 789,
											"top": 577,
											"width": 226.10693359375,
											"height": 13,
											"text": "+aplicarDescuento(descuento: Double)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFrl1z4HOWw=",
											"_parent": {
												"$ref": "AAAAAAGTl7ozsjkk3vg="
											},
											"model": {
												"$ref": "AAAAAAGTmFrl0z4EP50="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 789,
											"top": 592,
											"width": 226.10693359375,
											"height": 13,
											"text": "+mostrarInfo(): String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 784,
									"top": 557,
									"width": 236.10693359375,
									"height": 53
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTl7ozsjklHU4=",
									"_parent": {
										"$ref": "AAAAAAGTl7ozsTkdb9k="
									},
									"model": {
										"$ref": "AAAAAAGTl7ozsTkbeEA="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -74.2265625,
									"top": -190,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTl7ozsjkmask=",
									"_parent": {
										"$ref": "AAAAAAGTl7ozsTkdb9k="
									},
									"model": {
										"$ref": "AAAAAAGTl7ozsTkbeEA="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -74.2265625,
									"top": -190,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 784,
							"top": 464,
							"width": 235.10693359375,
							"height": 146,
							"nameCompartment": {
								"$ref": "AAAAAAGTl7ozsjkex0Y="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTl7ozsjkjES4="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTl7ozsjkk3vg="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTl7ozsjklHU4="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTl7ozsjkmask="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTl7uSsDloUbA=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTl7uSsDlpeOw=",
									"_parent": {
										"$ref": "AAAAAAGTl7uSsDloUbA="
									},
									"model": {
										"$ref": "AAAAAAGTl7uSsDlmvSs="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7uSsDlqu6I=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDlpeOw="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 304.54052734375,
											"top": 998,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7uSsDlru5M=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDlpeOw="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 13,
											"top": 175,
											"width": 257.85791015625,
											"height": 13,
											"text": "Cliente"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7uSsDlsNjU=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDlpeOw="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 304.54052734375,
											"top": 998,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7uSsDltD/k=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDlpeOw="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 304.54052734375,
											"top": 998,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 8,
									"top": 168,
									"width": 267.85791015625,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTl7uSsDlqu6I="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTl7uSsDlru5M="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTl7uSsDlsNjU="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTl7uSsDltD/k="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTl7uSsDluT8M=",
									"_parent": {
										"$ref": "AAAAAAGTl7uSsDloUbA="
									},
									"model": {
										"$ref": "AAAAAAGTl7uSsDlmvSs="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7uilTmTP2s=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDluT8M="
											},
											"model": {
												"$ref": "AAAAAAGTl7uijzmQbLA="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 198,
											"width": 257.85791015625,
											"height": 13,
											"text": "-idCliente: int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7uysTmaJG8=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDluT8M="
											},
											"model": {
												"$ref": "AAAAAAGTl7uyrjmXeJg="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 213,
											"width": 257.85791015625,
											"height": 13,
											"text": "-direccion: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7vLijmh9DI=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDluT8M="
											},
											"model": {
												"$ref": "AAAAAAGTl7vLhjmezUQ="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 228,
											"width": 257.85791015625,
											"height": 13,
											"text": "-nombre: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7vfczmoHtE=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDluT8M="
											},
											"model": {
												"$ref": "AAAAAAGTl7vfcDmlggw="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 243,
											"width": 257.85791015625,
											"height": 13,
											"text": "-apellido1: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7v14DmvjHM=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDluT8M="
											},
											"model": {
												"$ref": "AAAAAAGTl7v13Tms894="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 258,
											"width": 257.85791015625,
											"height": 13,
											"text": "-apellido2: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGVACzQcXc32AA=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDluT8M="
											},
											"model": {
												"$ref": "AAAAAAGVACzQaXc079o="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 273,
											"width": 257.85791015625,
											"height": 13,
											"text": "+telefonos: ArrayList<String>",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 8,
									"top": 193,
									"width": 267.85791015625,
									"height": 98
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTl7uSsDlvoBc=",
									"_parent": {
										"$ref": "AAAAAAGTl7uSsDloUbA="
									},
									"model": {
										"$ref": "AAAAAAGTl7uSsDlmvSs="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFLBDj0eWqc=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDlvoBc="
											},
											"model": {
												"$ref": "AAAAAAGTmFLBCj0bZhk="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 296,
											"width": 257.85791015625,
											"height": 13,
											"text": "+registrarCompra(compra: Compra)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFs4UD4R65Y=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDlvoBc="
											},
											"model": {
												"$ref": "AAAAAAGTmFs4Sz4O2B8="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 311,
											"width": 257.85791015625,
											"height": 13,
											"text": "+actualizarDireccion(nuevaDireccion: String)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFuaGz4eaFU=",
											"_parent": {
												"$ref": "AAAAAAGTl7uSsDlvoBc="
											},
											"model": {
												"$ref": "AAAAAAGTmFuaFj4bqnU="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 13,
											"top": 326,
											"width": 257.85791015625,
											"height": 13,
											"text": "+obtenerNombreCompleto(): String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 8,
									"top": 291,
									"width": 267.85791015625,
									"height": 53
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTl7uSsDlwwPE=",
									"_parent": {
										"$ref": "AAAAAAGTl7uSsDloUbA="
									},
									"model": {
										"$ref": "AAAAAAGTl7uSsDlmvSs="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 152.270263671875,
									"top": 499,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTl7uSsDlxRwg=",
									"_parent": {
										"$ref": "AAAAAAGTl7uSsDloUbA="
									},
									"model": {
										"$ref": "AAAAAAGTl7uSsDlmvSs="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 152.270263671875,
									"top": 499,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 8,
							"top": 168,
							"width": 266.85791015625,
							"height": 176,
							"nameCompartment": {
								"$ref": "AAAAAAGTl7uSsDlpeOw="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTl7uSsDluT8M="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTl7uSsDlvoBc="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTl7uSsDlwwPE="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTl7uSsDlxRwg="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTl7yPEjnyXNg=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTl7yPEjnzJPE=",
									"_parent": {
										"$ref": "AAAAAAGTl7yPEjnyXNg="
									},
									"model": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7yPEjn0bkY=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjnzJPE="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 435.8984375,
											"top": 260,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7yPEjn1x3Q=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjnzJPE="
											},
											"font": "Arial;13;3",
											"parentStyle": true,
											"left": 853,
											"top": 39,
											"width": 249.9677734375,
											"height": 13,
											"text": "Empleado"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7yPEjn2O8I=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjnzJPE="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 435.8984375,
											"top": 260,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl7yPEjn3tSk=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjnzJPE="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 435.8984375,
											"top": 260,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 848,
									"top": 32,
									"width": 259.9677734375,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTl7yPEjn0bkY="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTl7yPEjn1x3Q="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTl7yPEjn2O8I="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTl7yPEjn3tSk="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTl7yPEjn4caM=",
									"_parent": {
										"$ref": "AAAAAAGTl7yPEjnyXNg="
									},
									"model": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7y8yToj8gA=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjn4caM="
											},
											"model": {
												"$ref": "AAAAAAGTl7y8wjogBaE="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 853,
											"top": 62,
											"width": 249.9677734375,
											"height": 13,
											"text": "-dni: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl70zYDoqr2U=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjn4caM="
											},
											"model": {
												"$ref": "AAAAAAGTl70zXTonQKo="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 853,
											"top": 77,
											"width": 249.9677734375,
											"height": 13,
											"text": "-salario: double",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl71GAToxE8Q=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjn4caM="
											},
											"model": {
												"$ref": "AAAAAAGTl71F/jouAB4="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 853,
											"top": 92,
											"width": 249.9677734375,
											"height": 13,
											"text": "-fnac: LocalDate",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7126jo4Ldo=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjn4caM="
											},
											"model": {
												"$ref": "AAAAAAGTl7125zo1rLc="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 853,
											"top": 107,
											"width": 249.9677734375,
											"height": 13,
											"text": "-nombre: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl72OiDo/ib0=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjn4caM="
											},
											"model": {
												"$ref": "AAAAAAGTl72Ogjo8z+Y="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 853,
											"top": 122,
											"width": 249.9677734375,
											"height": 13,
											"text": "-encargado: Empleado",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 848,
									"top": 57,
									"width": 259.9677734375,
									"height": 83
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTl7yPEjn5QuE=",
									"_parent": {
										"$ref": "AAAAAAGTl7yPEjnyXNg="
									},
									"model": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFzRsD5GWt0=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjn5QuE="
											},
											"model": {
												"$ref": "AAAAAAGTmFzRqT5D5jY="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 853,
											"top": 145,
											"width": 249.9677734375,
											"height": 13,
											"text": "+calcularEdad(): int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFzl+T5PjYo=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjn5QuE="
											},
											"model": {
												"$ref": "AAAAAAGTmFzl8z5Mxnk="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 853,
											"top": 160,
											"width": 249.9677734375,
											"height": 13,
											"text": "+asignarEncargado(encargado: Empleado)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFz3XT5Y7lI=",
											"_parent": {
												"$ref": "AAAAAAGTl7yPEjn5QuE="
											},
											"model": {
												"$ref": "AAAAAAGTmFz3WD5VK3I="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 853,
											"top": 175,
											"width": 249.9677734375,
											"height": 13,
											"text": "+mostrarInfo(): String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 848,
									"top": 140,
									"width": 259.9677734375,
									"height": 53
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTl7yPEjn6z6c=",
									"_parent": {
										"$ref": "AAAAAAGTl7yPEjnyXNg="
									},
									"model": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 217.94921875,
									"top": 130,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTl7yPEjn7t7w=",
									"_parent": {
										"$ref": "AAAAAAGTl7yPEjnyXNg="
									},
									"model": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 217.94921875,
									"top": 130,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 848,
							"top": 32,
							"width": 258.9677734375,
							"height": 161,
							"nameCompartment": {
								"$ref": "AAAAAAGTl7yPEjnzJPE="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTl7yPEjn4caM="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTl7yPEjn5QuE="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTl7yPEjn6z6c="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTl7yPEjn7t7w="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTl73WdjpLCoI=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTl73WdjpJ5RU="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTl73WdjpMHRo=",
									"_parent": {
										"$ref": "AAAAAAGTl73WdjpLCoI="
									},
									"model": {
										"$ref": "AAAAAAGTl73WdjpJ5RU="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl73WdjpN/uU=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpMHRo="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 383.724853515625,
											"top": 496,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl73WdjpOOwA=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpMHRo="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 1373,
											"top": 239,
											"width": 249.9677734375,
											"height": 13,
											"text": "Panadero"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl73WdjpPfqg=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpMHRo="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 383.724853515625,
											"top": 496,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl73WdjpQGwY=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpMHRo="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 383.724853515625,
											"top": 496,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1368,
									"top": 232,
									"width": 259.9677734375,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTl73WdjpN/uU="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTl73WdjpOOwA="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTl73WdjpPfqg="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTl73WdjpQGwY="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTl73WdjpR50M=",
									"_parent": {
										"$ref": "AAAAAAGTl73WdjpLCoI="
									},
									"model": {
										"$ref": "AAAAAAGTl73WdjpJ5RU="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl73kSzp2BtA=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpR50M="
											},
											"model": {
												"$ref": "AAAAAAGTl73kRzpzlFs="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1373,
											"top": 262,
											"width": 249.9677734375,
											"height": 13,
											"text": "-dni: String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1368,
									"top": 257,
									"width": 259.9677734375,
									"height": 23
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTl73WdjpSHZM=",
									"_parent": {
										"$ref": "AAAAAAGTl73WdjpLCoI="
									},
									"model": {
										"$ref": "AAAAAAGTl73WdjpJ5RU="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF0oDz5imUs=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpSHZM="
											},
											"model": {
												"$ref": "AAAAAAGTmF0oCT5fHhQ="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1373,
											"top": 285,
											"width": 249.9677734375,
											"height": 13,
											"text": "+prepararProducto(producto: Propio)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMmckQhcL/A=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpSHZM="
											},
											"model": {
												"$ref": "AAAAAAGVAMmcjAhZv2A="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1373,
											"top": 300,
											"width": 249.9677734375,
											"height": 13,
											"text": "+calcularEdad(): int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMnkyx3UUWQ=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpSHZM="
											},
											"model": {
												"$ref": "AAAAAAGVAMnkxh3R6Sc="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1373,
											"top": 315,
											"width": 249.9677734375,
											"height": 13,
											"text": "+asignarEncargado(encargado: Empleado)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMuvF4x7dYo=",
											"_parent": {
												"$ref": "AAAAAAGTl73WdjpSHZM="
											},
											"model": {
												"$ref": "AAAAAAGVAMuvE4x4AGo="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1373,
											"top": 330,
											"width": 249.9677734375,
											"height": 13,
											"text": "+mostrarInfo(): String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1368,
									"top": 280,
									"width": 259.9677734375,
									"height": 68
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTl73WdjpTAus=",
									"_parent": {
										"$ref": "AAAAAAGTl73WdjpLCoI="
									},
									"model": {
										"$ref": "AAAAAAGTl73WdjpJ5RU="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 322.7515869140625,
									"top": -2.5,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTl73WdjpUmyM=",
									"_parent": {
										"$ref": "AAAAAAGTl73WdjpLCoI="
									},
									"model": {
										"$ref": "AAAAAAGTl73WdjpJ5RU="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 322.7515869140625,
									"top": -2.5,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 1368,
							"top": 232,
							"width": 258.9677734375,
							"height": 116,
							"nameCompartment": {
								"$ref": "AAAAAAGTl73WdjpMHRo="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTl73WdjpR50M="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTl73WdjpSHZM="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTl73WdjpTAus="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTl73WdjpUmyM="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTl74dmjqGVG0=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTl74dmjqHrcw=",
									"_parent": {
										"$ref": "AAAAAAGTl74dmjqGVG0="
									},
									"model": {
										"$ref": "AAAAAAGTl74dmjqEkd4="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl74dmjqIyQg=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqHrcw="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 382.908203125,
											"top": 866,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl74dmjqJxgA=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqHrcw="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 829,
											"top": 263,
											"width": 340.96142578125,
											"height": 13,
											"text": "Dependiente"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl74dmjqKHfs=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqHrcw="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 382.908203125,
											"top": 866,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl74dmjqLjtc=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqHrcw="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 382.908203125,
											"top": 866,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 824,
									"top": 256,
									"width": 350.96142578125,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTl74dmjqIyQg="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTl74dmjqJxgA="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTl74dmjqKHfs="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTl74dmjqLjtc="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTl74dmjqMYk8=",
									"_parent": {
										"$ref": "AAAAAAGTl74dmjqGVG0="
									},
									"model": {
										"$ref": "AAAAAAGTl74dmjqEkd4="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl75A+Tqx+A4=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqMYk8="
											},
											"model": {
												"$ref": "AAAAAAGTl75A9Dquhl4="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 829,
											"top": 286,
											"width": 340.96142578125,
											"height": 13,
											"text": "-dni: String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 824,
									"top": 281,
									"width": 350.96142578125,
									"height": 23
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTl74dmjqNjgQ=",
									"_parent": {
										"$ref": "AAAAAAGTl74dmjqGVG0="
									},
									"model": {
										"$ref": "AAAAAAGTl74dmjqEkd4="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF1lKT5yQx8=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqNjgQ="
											},
											"model": {
												"$ref": "AAAAAAGTmF1lIz5vtI0="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 829,
											"top": 309,
											"width": 340.96142578125,
											"height": 13,
											"text": "+atenderCliente(cliente: Cliente)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF2lUT5/bjE=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqNjgQ="
											},
											"model": {
												"$ref": "AAAAAAGTmF2lSj58HrI="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 829,
											"top": 324,
											"width": 340.96142578125,
											"height": 13,
											"text": "+aplicarDescuento(compra: Compra, descuento: Double)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMl6DgBSiIY=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqNjgQ="
											},
											"model": {
												"$ref": "AAAAAAGVAMl6CQBP+Ko="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 829,
											"top": 339,
											"width": 340.96142578125,
											"height": 13,
											"text": "+calcularEdad(): int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMnBZxNUGFs=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqNjgQ="
											},
											"model": {
												"$ref": "AAAAAAGVAMnBYhNRW3M="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 829,
											"top": 354,
											"width": 340.96142578125,
											"height": 13,
											"text": "+asignarEncargado(encargado: Empleado)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMtKLX7ISxo=",
											"_parent": {
												"$ref": "AAAAAAGTl74dmjqNjgQ="
											},
											"model": {
												"$ref": "AAAAAAGVAMtKKX7FcWc="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 829,
											"top": 369,
											"width": 340.96142578125,
											"height": 13,
											"text": "+mostrarInfo(): String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 824,
									"top": 304,
									"width": 350.96142578125,
									"height": 83
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTl74dmjqOh9M=",
									"_parent": {
										"$ref": "AAAAAAGTl74dmjqGVG0="
									},
									"model": {
										"$ref": "AAAAAAGTl74dmjqEkd4="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 191.4541015625,
									"top": 433,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTl74dmjqPvqc=",
									"_parent": {
										"$ref": "AAAAAAGTl74dmjqGVG0="
									},
									"model": {
										"$ref": "AAAAAAGTl74dmjqEkd4="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 191.4541015625,
									"top": 433,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 824,
							"top": 256,
							"width": 349.96142578125,
							"height": 131,
							"nameCompartment": {
								"$ref": "AAAAAAGTl74dmjqHrcw="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTl74dmjqMYk8="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTl74dmjqNjgQ="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTl74dmjqOh9M="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTl74dmjqPvqc="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTl75cjzq4M1M=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTl75cjzq5wlQ=",
									"_parent": {
										"$ref": "AAAAAAGTl75cjzq4M1M="
									},
									"model": {
										"$ref": "AAAAAAGTl75cjzq2BZM="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl75cjzq6F+c=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq5wlQ="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 225.82421875,
											"top": 852,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl75cjzq7F24=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq5wlQ="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 321.85791015625,
											"top": 223,
											"width": 381.427734375,
											"height": 13,
											"text": "Repartidor"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl75cjzq85so=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq5wlQ="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 225.82421875,
											"top": 852,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl75cjzq9Kak=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq5wlQ="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 225.82421875,
											"top": 852,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 316.85791015625,
									"top": 216,
									"width": 391.427734375,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTl75cjzq6F+c="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTl75cjzq7F24="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTl75cjzq85so="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTl75cjzq9Kak="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTl75cjzq+kEg=",
									"_parent": {
										"$ref": "AAAAAAGTl75cjzq4M1M="
									},
									"model": {
										"$ref": "AAAAAAGTl75cjzq2BZM="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7586jrkTpA=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq+kEg="
											},
											"model": {
												"$ref": "AAAAAAGTl7585jrhnKA="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 321.85791015625,
											"top": 246,
											"width": 381.427734375,
											"height": 13,
											"text": "-dni: String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 316.85791015625,
									"top": 241,
									"width": 391.427734375,
									"height": 23
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTl75cjzq/mTg=",
									"_parent": {
										"$ref": "AAAAAAGTl75cjzq4M1M="
									},
									"model": {
										"$ref": "AAAAAAGTl75cjzq2BZM="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF31Vz6PTq4=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq/mTg="
											},
											"model": {
												"$ref": "AAAAAAGTmF31UT6Mvg4="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 321.85791015625,
											"top": 269,
											"width": 381.427734375,
											"height": 13,
											"text": "+realizarEntrega(compra: Compra, fecha: LocalDate, hora: String)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMlxA/15L6c=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq/mTg="
											},
											"model": {
												"$ref": "AAAAAAGVAMlw+f12pS8="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 321.85791015625,
											"top": 284,
											"width": 381.427734375,
											"height": 13,
											"text": "+calcularEdad(): int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMm32BB7rnU=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq/mTg="
											},
											"model": {
												"$ref": "AAAAAAGVAMm30BB4kOk="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 321.85791015625,
											"top": 299,
											"width": 381.427734375,
											"height": 13,
											"text": "+asignarEncargado(encargado: Empleado)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAMs+pnvvl48=",
											"_parent": {
												"$ref": "AAAAAAGTl75cjzq/mTg="
											},
											"model": {
												"$ref": "AAAAAAGVAMs+n3vsd8E="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 321.85791015625,
											"top": 314,
											"width": 381.427734375,
											"height": 13,
											"text": "+mostrarInfo(): String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 316.85791015625,
									"top": 264,
									"width": 391.427734375,
									"height": 68
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTl75cjzrA0Jg=",
									"_parent": {
										"$ref": "AAAAAAGTl75cjzq4M1M="
									},
									"model": {
										"$ref": "AAAAAAGTl75cjzq2BZM="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 112.912109375,
									"top": 426,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTl75cjzrBs8k=",
									"_parent": {
										"$ref": "AAAAAAGTl75cjzq4M1M="
									},
									"model": {
										"$ref": "AAAAAAGTl75cjzq2BZM="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 112.912109375,
									"top": 426,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 316.85791015625,
							"top": 216,
							"width": 390.427734375,
							"height": 116,
							"nameCompartment": {
								"$ref": "AAAAAAGTl75cjzq5wlQ="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTl75cjzq+kEg="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTl75cjzq/mTg="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTl75cjzrA0Jg="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTl75cjzrBs8k="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTl76eUDrrCSU=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTl76eUDrsmug=",
									"_parent": {
										"$ref": "AAAAAAGTl76eUDrrCSU="
									},
									"model": {
										"$ref": "AAAAAAGTl76eUDrpj1I="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl76eUDrt+Os=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrsmug="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -1254.73779296875,
											"top": 1240,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl76eUDrul5I=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrsmug="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 424,
											"width": 247.73974609375,
											"height": 13,
											"text": "Compra"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl76eUDrv7kQ=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrsmug="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -1254.73779296875,
											"top": 1240,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTl76eUDrwxB4=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrsmug="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -1254.73779296875,
											"top": 1240,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 321.8118896484375,
									"top": 417,
									"width": 257.73974609375,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTl76eUDrt+Os="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTl76eUDrul5I="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTl76eUDrv7kQ="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTl76eUDrwxB4="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTl76eUDrxDOQ=",
									"_parent": {
										"$ref": "AAAAAAGTl76eUDrrCSU="
									},
									"model": {
										"$ref": "AAAAAAGTl76eUDrpj1I="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl76phDsWdFk=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl76pgDsT5nQ="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 447,
											"width": 247.73974609375,
											"height": 13,
											"text": "-numCompra: int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl77VAjse4gM=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl77U/jsbnrs="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 462,
											"width": 247.73974609375,
											"height": 13,
											"text": "-fecha: LocalDate",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl77s0Tsl2sQ=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl77szTsiNcE="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 477,
											"width": 247.73974609375,
											"height": 13,
											"text": "-cliente: Cliente",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl78EWTssM4c=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl78EUTspCeA="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 492,
											"width": 247.73974609375,
											"height": 13,
											"text": "-dependiente: Dependiente",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl78a/zsz9to=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl78a+zswLX0="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 507,
											"width": 247.73974609375,
											"height": 13,
											"text": "-descuentoDependiente: double",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl79T8zs6JU0=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl79T7zs3mgQ="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 522,
											"width": 247.73974609375,
											"height": 13,
											"text": "-fechaDependiente: LocalDate",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl79nWjtBkas=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl79nVDs+wgs="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 537,
											"width": 247.73974609375,
											"height": 13,
											"text": "-repartidor: Repartidor",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl79+VztI1lg=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl79+VDtFfcM="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 552,
											"width": 247.73974609375,
											"height": 13,
											"text": "-fechaRepartidor: LocalDate",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTl7+bsTtPick=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUDrxDOQ="
											},
											"model": {
												"$ref": "AAAAAAGTl7+brjtM3EI="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 567,
											"width": 247.73974609375,
											"height": 13,
											"text": "-horaRepartidor: LocalTime",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 321.8118896484375,
									"top": 442,
									"width": 257.73974609375,
									"height": 143
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTl76eUTryQYg=",
									"_parent": {
										"$ref": "AAAAAAGTl76eUDrrCSU="
									},
									"model": {
										"$ref": "AAAAAAGTl76eUDrpj1I="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFW5Dj3WBoc=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUTryQYg="
											},
											"model": {
												"$ref": "AAAAAAGTmFW5CT3TFiE="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 590,
											"width": 247.73974609375,
											"height": 13,
											"text": "+registrarLinea(linea: Linea_De_Ticket)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFZLVz3gpho=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUTryQYg="
											},
											"model": {
												"$ref": "AAAAAAGTmFZLUT3dHNU="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 605,
											"width": 247.73974609375,
											"height": 13,
											"text": "+calcularTotal(): double",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF5Pbj6gDXk=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUTryQYg="
											},
											"model": {
												"$ref": "AAAAAAGTmF5PZj6dtHc="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 620,
											"width": 247.73974609375,
											"height": 13,
											"text": "+asociarCliente(cliente: Cliente)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTu7uOOTBGAUU=",
											"_parent": {
												"$ref": "AAAAAAGTl76eUTryQYg="
											},
											"model": {
												"$ref": "AAAAAAGTu7uOKjBDGTM="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 326.8118896484375,
											"top": 635,
											"width": 247.73974609375,
											"height": 13,
											"text": "+generarFactura(): String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 321.8118896484375,
									"top": 585,
									"width": 257.73974609375,
									"height": 68
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTl76eUTrzxz4=",
									"_parent": {
										"$ref": "AAAAAAGTl76eUDrrCSU="
									},
									"model": {
										"$ref": "AAAAAAGTl76eUDrpj1I="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -630.73779296875,
									"top": 620,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTl76eUTr0whs=",
									"_parent": {
										"$ref": "AAAAAAGTl76eUDrrCSU="
									},
									"model": {
										"$ref": "AAAAAAGTl76eUDrpj1I="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -630.73779296875,
									"top": 620,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 321.8118896484375,
							"top": 417,
							"width": 256.73974609375,
							"height": 236,
							"nameCompartment": {
								"$ref": "AAAAAAGTl76eUDrsmug="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTl76eUDrxDOQ="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTl76eUTryQYg="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTl76eUTrzxz4="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTl76eUTr0whs="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTmEaGoTtVwAo=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTmEaGoTtWPp4=",
									"_parent": {
										"$ref": "AAAAAAGTmEaGoTtVwAo="
									},
									"model": {
										"$ref": "AAAAAAGTmEaGoDtT2U8="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEaGoTtXplU=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtWPp4="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3323.445068359375,
											"top": 1080,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEaGoTtYMKM=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtWPp4="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 405,
											"top": 791,
											"width": 290.1357421875,
											"height": 13,
											"text": "Linea_De_Ticket"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEaGoTtZy5Q=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtWPp4="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3323.445068359375,
											"top": 1080,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEaGoTtaMvU=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtWPp4="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3323.445068359375,
											"top": 1080,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 400,
									"top": 784,
									"width": 300.1357421875,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTmEaGoTtXplU="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTmEaGoTtYMKM="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTmEaGoTtZy5Q="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTmEaGoTtaMvU="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTmEaGoTtbeck=",
									"_parent": {
										"$ref": "AAAAAAGTmEaGoTtVwAo="
									},
									"model": {
										"$ref": "AAAAAAGTmEaGoDtT2U8="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEauLjuAswo=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtbeck="
											},
											"model": {
												"$ref": "AAAAAAGTmEauJDt9l2M="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 405,
											"top": 814,
											"width": 290.1357421875,
											"height": 13,
											"text": "-compra: Compra",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEhn3jvXe+s=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtbeck="
											},
											"model": {
												"$ref": "AAAAAAGTmEhn2DvUWgA="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 405,
											"top": 829,
											"width": 290.1357421875,
											"height": 13,
											"text": "-numLinea: int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEh/QzvebxU=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtbeck="
											},
											"model": {
												"$ref": "AAAAAAGTmEh/PjvbKWs="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 405,
											"top": 844,
											"width": 290.1357421875,
											"height": 13,
											"text": "-producto: Producto",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEjxXjvl7sc=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtbeck="
											},
											"model": {
												"$ref": "AAAAAAGTmEjxWTviaHg="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 405,
											"top": 859,
											"width": 290.1357421875,
											"height": 13,
											"text": "-cantidad: int",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 400,
									"top": 809,
									"width": 300.1357421875,
									"height": 68
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTmEaGoTtciCQ=",
									"_parent": {
										"$ref": "AAAAAAGTmEaGoTtVwAo="
									},
									"model": {
										"$ref": "AAAAAAGTmEaGoDtT2U8="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmFSf8j29Fp0=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtciCQ="
											},
											"model": {
												"$ref": "AAAAAAGTmFSf7D2675M="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 405,
											"top": 882,
											"width": 290.1357421875,
											"height": 13,
											"text": "+añadirProducto(int cantidad, String producto)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF6waz6s7sY=",
											"_parent": {
												"$ref": "AAAAAAGTmEaGoTtciCQ="
											},
											"model": {
												"$ref": "AAAAAAGTmF6wZD6pHlk="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 405,
											"top": 897,
											"width": 290.1357421875,
											"height": 13,
											"text": "+calcularSubtotal(producto: Producto): Double",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 400,
									"top": 877,
									"width": 300.1357421875,
									"height": 38
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTmEaGoTtdHpw=",
									"_parent": {
										"$ref": "AAAAAAGTmEaGoTtVwAo="
									},
									"model": {
										"$ref": "AAAAAAGTmEaGoDtT2U8="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -1661.7225341796875,
									"top": 540,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTmEaGoTtebAA=",
									"_parent": {
										"$ref": "AAAAAAGTmEaGoTtVwAo="
									},
									"model": {
										"$ref": "AAAAAAGTmEaGoDtT2U8="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -1661.7225341796875,
									"top": 540,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 400,
							"top": 784,
							"width": 299.1357421875,
							"height": 131,
							"nameCompartment": {
								"$ref": "AAAAAAGTmEaGoTtWPp4="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTmEaGoTtbeck="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTmEaGoTtciCQ="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTmEaGoTtdHpw="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTmEaGoTtebAA="
							}
						},
						{
							"_type": "UMLGeneralizationView",
							"_id": "AAAAAAGTmEe0fzuiO0Y=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEe0fzug430="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEe0fzujZB4=",
									"_parent": {
										"$ref": "AAAAAAGTmEe0fzuiO0Y="
									},
									"model": {
										"$ref": "AAAAAAGTmEe0fzug430="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1472,
									"top": 204,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEe0fzuiO0Y="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEe0fzukI3E=",
									"_parent": {
										"$ref": "AAAAAAGTmEe0fzuiO0Y="
									},
									"model": {
										"$ref": "AAAAAAGTmEe0fzug430="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1470,
									"top": 219,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGTmEe0fzuiO0Y="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEe0fzulzv8=",
									"_parent": {
										"$ref": "AAAAAAGTmEe0fzuiO0Y="
									},
									"model": {
										"$ref": "AAAAAAGTmEe0fzug430="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1477,
									"top": 175,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEe0fzuiO0Y="
									},
									"edgePosition": 1
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl7yPEjnyXNg="
							},
							"tail": {
								"$ref": "AAAAAAGTl73WdjpLCoI="
							},
							"lineStyle": 3,
							"points": "1483:231;1475:196;1108:134",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGTmEe0fzujZB4="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGTmEe0fzukI3E="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGTmEe0fzulzv8="
							}
						},
						{
							"_type": "UMLGeneralizationView",
							"_id": "AAAAAAGTmEfBFDuzU/k=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEfBFDuxxOk="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEfBFDu0riQ=",
									"_parent": {
										"$ref": "AAAAAAGTmEfBFDuzU/k="
									},
									"model": {
										"$ref": "AAAAAAGTmEfBFDuxxOk="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 509,
									"top": 175,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEfBFDuzU/k="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEfBFDu1lBk=",
									"_parent": {
										"$ref": "AAAAAAGTmEfBFDuzU/k="
									},
									"model": {
										"$ref": "AAAAAAGTmEfBFDuxxOk="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 506,
									"top": 160,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGTmEfBFDuzU/k="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEfBFDu2D9o=",
									"_parent": {
										"$ref": "AAAAAAGTmEfBFDuzU/k="
									},
									"model": {
										"$ref": "AAAAAAGTmEfBFDuxxOk="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 514,
									"top": 204,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEfBFDuzU/k="
									},
									"edgePosition": 1
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl7yPEjnyXNg="
							},
							"tail": {
								"$ref": "AAAAAAGTl75cjzq4M1M="
							},
							"lineStyle": 3,
							"points": "512:215;512:196;847:135",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGTmEfBFDu0riQ="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGTmEfBFDu1lBk="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGTmEfBFDu2D9o="
							}
						},
						{
							"_type": "UMLGeneralizationView",
							"_id": "AAAAAAGTmEfLcjvEpzM=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEfLcjvCyUg="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEfLcjvFmHQ=",
									"_parent": {
										"$ref": "AAAAAAGTmEfLcjvEpzM="
									},
									"model": {
										"$ref": "AAAAAAGTmEfLcjvCyUg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 973,
									"top": 219,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEfLcjvEpzM="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEfLcjvGXQA=",
									"_parent": {
										"$ref": "AAAAAAGTmEfLcjvEpzM="
									},
									"model": {
										"$ref": "AAAAAAGTmEfLcjvCyUg="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 958,
									"top": 220,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGTmEfLcjvEpzM="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEfLcjvHgAw=",
									"_parent": {
										"$ref": "AAAAAAGTmEfLcjvEpzM="
									},
									"model": {
										"$ref": "AAAAAAGTmEfLcjvCyUg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1002,
									"top": 216,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEfLcjvEpzM="
									},
									"edgePosition": 1
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl7yPEjnyXNg="
							},
							"tail": {
								"$ref": "AAAAAAGTl74dmjqGVG0="
							},
							"lineStyle": 3,
							"points": "991:255;985:194",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGTmEfLcjvFmHQ="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGTmEfLcjvGXQA="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGTmEfLcjvHgAw="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTmEmwODv6KnE=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTmEmwODv7194=",
									"_parent": {
										"$ref": "AAAAAAGTmEmwODv6KnE="
									},
									"model": {
										"$ref": "AAAAAAGTmEmwODv4Siw="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEmwODv8dzk=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODv7194="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -943.101806640625,
											"top": -323,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEmwODv9MbY=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODv7194="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 893,
											"top": 767,
											"width": 226.10693359375,
											"height": 13,
											"text": "Ajeno"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEmwODv+pK8=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODv7194="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -943.101806640625,
											"top": -323,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEmwODv/UCk=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODv7194="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -943.101806640625,
											"top": -323,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 888,
									"top": 760,
									"width": 236.10693359375,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTmEmwODv8dzk="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTmEmwODv9MbY="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTmEmwODv+pK8="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTmEmwODv/UCk="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTmEmwODwA3qE=",
									"_parent": {
										"$ref": "AAAAAAGTmEmwODv6KnE="
									},
									"model": {
										"$ref": "AAAAAAGTmEmwODv4Siw="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEnBLjwld/I=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODwA3qE="
											},
											"model": {
												"$ref": "AAAAAAGTmEnBJjwih9k="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 893,
											"top": 790,
											"width": 226.10693359375,
											"height": 13,
											"text": "-codigo: int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGVACZvql02tYw=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODwA3qE="
											},
											"model": {
												"$ref": "AAAAAAGVACZvml0z3lw="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 893,
											"top": 805,
											"width": 226.10693359375,
											"height": 13,
											"text": "+proveedor: ArrayList<Proveedor>",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 888,
									"top": 785,
									"width": 236.10693359375,
									"height": 38
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTmEmwODwBK7w=",
									"_parent": {
										"$ref": "AAAAAAGTmEmwODv6KnE="
									},
									"model": {
										"$ref": "AAAAAAGTmEmwODv4Siw="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF7RXD63GuA=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODwBK7w="
											},
											"model": {
												"$ref": "AAAAAAGTmF7RVT60a/Q="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 893,
											"top": 828,
											"width": 226.10693359375,
											"height": 13,
											"text": "+mostrarInfo(): String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAM3MGeg8vGU=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODwBK7w="
											},
											"model": {
												"$ref": "AAAAAAGVAM3MD+g5f0I="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 893,
											"top": 843,
											"width": 226.10693359375,
											"height": 13,
											"text": "+calcularImpuesto(): double",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAM3yq/CC4FY=",
											"_parent": {
												"$ref": "AAAAAAGTmEmwODwBK7w="
											},
											"model": {
												"$ref": "AAAAAAGVAM3ypPB/7gs="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 893,
											"top": 858,
											"width": 226.10693359375,
											"height": 13,
											"text": "+aplicarDescuento(descuento: Double)",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 888,
									"top": 823,
									"width": 236.10693359375,
									"height": 53
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTmEmwODwC0bg=",
									"_parent": {
										"$ref": "AAAAAAGTmEmwODv6KnE="
									},
									"model": {
										"$ref": "AAAAAAGTmEmwODv4Siw="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -471.5509033203125,
									"top": -161.5,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTmEmwOTwDcFk=",
									"_parent": {
										"$ref": "AAAAAAGTmEmwODv6KnE="
									},
									"model": {
										"$ref": "AAAAAAGTmEmwODv4Siw="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -471.5509033203125,
									"top": -161.5,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 888,
							"top": 760,
							"width": 235.10693359375,
							"height": 116,
							"nameCompartment": {
								"$ref": "AAAAAAGTmEmwODv7194="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTmEmwODwA3qE="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTmEmwODwBK7w="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTmEmwODwC0bg="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTmEmwOTwDcFk="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTmEn9sjwyYYw=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTmEn9sjwz8Js=",
									"_parent": {
										"$ref": "AAAAAAGTmEn9sjwyYYw="
									},
									"model": {
										"$ref": "AAAAAAGTmEn9sjwwr+I="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEn9sjw0+vY=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjwz8Js="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 366.239990234375,
											"top": -515,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEn9sjw1oBU=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjwz8Js="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 1197,
											"top": 751,
											"width": 236.96142578125,
											"height": 13,
											"text": "Propio"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEn9sjw2SD0=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjwz8Js="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 366.239990234375,
											"top": -515,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEn9sjw3W9w=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjwz8Js="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 366.239990234375,
											"top": -515,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1192,
									"top": 744,
									"width": 246.96142578125,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTmEn9sjw0+vY="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTmEn9sjw1oBU="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTmEn9sjw2SD0="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTmEn9sjw3W9w="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTmEn9sjw4h1A=",
									"_parent": {
										"$ref": "AAAAAAGTmEn9sjwyYYw="
									},
									"model": {
										"$ref": "AAAAAAGTmEn9sjwwr+I="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEoMATxdWDo=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjw4h1A="
											},
											"model": {
												"$ref": "AAAAAAGTmEoL9jxaY8Q="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1197,
											"top": 774,
											"width": 236.96142578125,
											"height": 13,
											"text": "-codigo: int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGVACof12NUuco=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjw4h1A="
											},
											"model": {
												"$ref": "AAAAAAGVACofzGNRGUA="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1197,
											"top": 789,
											"width": 236.96142578125,
											"height": 13,
											"text": "+panadero: ArrayList<Panadero>",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGVADmygviV6XE=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjw4h1A="
											},
											"model": {
												"$ref": "AAAAAAGVADmyfPiScSU="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1197,
											"top": 804,
											"width": 236.96142578125,
											"height": 13,
											"text": "+ingrediente: ArrayList<Ingrediente>",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGVALyFO+naIUk=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjw4h1A="
											},
											"model": {
												"$ref": "AAAAAAGVALyFK+nXNUk="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1197,
											"top": 819,
											"width": 236.96142578125,
											"height": 13,
											"text": "+cantidadIngrediente: ArrayList<Integer>",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1192,
									"top": 769,
									"width": 246.96142578125,
									"height": 68
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTmEn9sjw5NFk=",
									"_parent": {
										"$ref": "AAAAAAGTmEn9sjwyYYw="
									},
									"model": {
										"$ref": "AAAAAAGTmEn9sjwwr+I="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF7ajD7AAc0=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjw5NFk="
											},
											"model": {
												"$ref": "AAAAAAGTmF7ahD692qQ="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1197,
											"top": 842,
											"width": 236.96142578125,
											"height": 13,
											"text": "+mostrarInfo(): String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAM3W/etRUTs=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjw5NFk="
											},
											"model": {
												"$ref": "AAAAAAGVAM3W9+tOSas="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1197,
											"top": 857,
											"width": 236.96142578125,
											"height": 13,
											"text": "+calcularImpuesto(): double",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGVAM36CvNboqI=",
											"_parent": {
												"$ref": "AAAAAAGTmEn9sjw5NFk="
											},
											"model": {
												"$ref": "AAAAAAGVAM36BPNYirA="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1197,
											"top": 872,
											"width": 236.96142578125,
											"height": 13,
											"text": "+aplicarDescuento(descuento: Double)",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1192,
									"top": 837,
									"width": 246.96142578125,
									"height": 53
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTmEn9sjw6gK4=",
									"_parent": {
										"$ref": "AAAAAAGTmEn9sjwyYYw="
									},
									"model": {
										"$ref": "AAAAAAGTmEn9sjwwr+I="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 205.0609130859375,
									"top": -647.5,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTmEn9sjw7Gg0=",
									"_parent": {
										"$ref": "AAAAAAGTmEn9sjwyYYw="
									},
									"model": {
										"$ref": "AAAAAAGTmEn9sjwwr+I="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 205.0609130859375,
									"top": -647.5,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 1192,
							"top": 744,
							"width": 245.96142578125,
							"height": 146,
							"nameCompartment": {
								"$ref": "AAAAAAGTmEn9sjwz8Js="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTmEn9sjw4h1A="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTmEn9sjw5NFk="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTmEn9sjw6gK4="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTmEn9sjw7Gg0="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTmEp7aDxo3ic=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEp7aDxmzMI="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTmEp7aDxpyTY=",
									"_parent": {
										"$ref": "AAAAAAGTmEp7aDxo3ic="
									},
									"model": {
										"$ref": "AAAAAAGTmEp7aDxmzMI="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEp7aDxqonQ=",
											"_parent": {
												"$ref": "AAAAAAGTmEp7aDxpyTY="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3433.80224609375,
											"top": 1423,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEp7aDxrpaU=",
											"_parent": {
												"$ref": "AAAAAAGTmEp7aDxpyTY="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 1093,
											"top": 431,
											"width": 282.353515625,
											"height": 13,
											"text": "Proveedor"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEp7aDxs5IQ=",
											"_parent": {
												"$ref": "AAAAAAGTmEp7aDxpyTY="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3433.80224609375,
											"top": 1423,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmEp7aTxt01w=",
											"_parent": {
												"$ref": "AAAAAAGTmEp7aDxpyTY="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3433.80224609375,
											"top": 1423,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1088,
									"top": 424,
									"width": 292.353515625,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTmEp7aDxqonQ="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTmEp7aDxrpaU="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTmEp7aDxs5IQ="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTmEp7aTxt01w="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTmEp7aTxulf4=",
									"_parent": {
										"$ref": "AAAAAAGTmEp7aDxo3ic="
									},
									"model": {
										"$ref": "AAAAAAGTmEp7aDxmzMI="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEqMQzyTXFw=",
											"_parent": {
												"$ref": "AAAAAAGTmEp7aTxulf4="
											},
											"model": {
												"$ref": "AAAAAAGTmEqMOzyQJBc="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1093,
											"top": 454,
											"width": 282.353515625,
											"height": 13,
											"text": "-codProveedor: int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEqsAzybjz0=",
											"_parent": {
												"$ref": "AAAAAAGTmEp7aTxulf4="
											},
											"model": {
												"$ref": "AAAAAAGTmEqr/TyYvys="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1093,
											"top": 469,
											"width": 282.353515625,
											"height": 13,
											"text": "-nombre: String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1088,
									"top": 449,
									"width": 292.353515625,
									"height": 38
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTmEp7aTxvVtI=",
									"_parent": {
										"$ref": "AAAAAAGTmEp7aDxo3ic="
									},
									"model": {
										"$ref": "AAAAAAGTmEp7aDxmzMI="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF8XfT7JW2M=",
											"_parent": {
												"$ref": "AAAAAAGTmEp7aTxvVtI="
											},
											"model": {
												"$ref": "AAAAAAGTmF8XdT7GAR8="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1093,
											"top": 492,
											"width": 282.353515625,
											"height": 13,
											"text": "+registrarSuministro(Ajeno ajeno)",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF8rZT7SAJI=",
											"_parent": {
												"$ref": "AAAAAAGTmEp7aTxvVtI="
											},
											"model": {
												"$ref": "AAAAAAGTmF8rXT7P0mg="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1093,
											"top": 507,
											"width": 282.353515625,
											"height": 13,
											"text": "+registrarVenta(Ingrediente ingrediente)",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1088,
									"top": 487,
									"width": 292.353515625,
									"height": 38
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTmEp7aTxwn3w=",
									"_parent": {
										"$ref": "AAAAAAGTmEp7aDxo3ic="
									},
									"model": {
										"$ref": "AAAAAAGTmEp7aDxmzMI="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -1612.901123046875,
									"top": 1255.5,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTmEp7aTxxdVg=",
									"_parent": {
										"$ref": "AAAAAAGTmEp7aDxo3ic="
									},
									"model": {
										"$ref": "AAAAAAGTmEp7aDxmzMI="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -1612.901123046875,
									"top": 1255.5,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 1088,
							"top": 424,
							"width": 291.353515625,
							"height": 104,
							"nameCompartment": {
								"$ref": "AAAAAAGTmEp7aDxpyTY="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTmEp7aTxulf4="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTmEp7aTxvVtI="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTmEp7aTxwn3w="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTmEp7aTxxdVg="
							}
						},
						{
							"_type": "UMLClassView",
							"_id": "AAAAAAGTmErYAzyi9CQ=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmErYAzygzHM="
							},
							"subViews": [
								{
									"_type": "UMLNameCompartmentView",
									"_id": "AAAAAAGTmErYAzyjFXg=",
									"_parent": {
										"$ref": "AAAAAAGTmErYAzyi9CQ="
									},
									"model": {
										"$ref": "AAAAAAGTmErYAzygzHM="
									},
									"subViews": [
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmErYAzykSyU=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzyjFXg="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3239.01513671875,
											"top": 1200,
											"height": 13
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmErYAzylEws=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzyjFXg="
											},
											"font": "Arial;13;1",
											"parentStyle": true,
											"left": 1637,
											"top": 484,
											"width": 200.80517578125,
											"height": 13,
											"text": "Ingrediente"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmErYAzymuAs=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzyjFXg="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3239.01513671875,
											"top": 1200,
											"width": 73.67724609375,
											"height": 13,
											"text": "(from Model)"
										},
										{
											"_type": "LabelView",
											"_id": "AAAAAAGTmErYAzynT0g=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzyjFXg="
											},
											"visible": false,
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": -3239.01513671875,
											"top": 1200,
											"height": 13,
											"horizontalAlignment": 1
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1632,
									"top": 477,
									"width": 210.80517578125,
									"height": 25,
									"stereotypeLabel": {
										"$ref": "AAAAAAGTmErYAzykSyU="
									},
									"nameLabel": {
										"$ref": "AAAAAAGTmErYAzylEws="
									},
									"namespaceLabel": {
										"$ref": "AAAAAAGTmErYAzymuAs="
									},
									"propertyLabel": {
										"$ref": "AAAAAAGTmErYAzynT0g="
									}
								},
								{
									"_type": "UMLAttributeCompartmentView",
									"_id": "AAAAAAGTmErYAzyothk=",
									"_parent": {
										"$ref": "AAAAAAGTmErYAzyi9CQ="
									},
									"model": {
										"$ref": "AAAAAAGTmErYAzygzHM="
									},
									"subViews": [
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmErrFTzNfE8=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzyothk="
											},
											"model": {
												"$ref": "AAAAAAGTmErrDjzKrXk="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1637,
											"top": 507,
											"width": 200.80517578125,
											"height": 13,
											"text": "-codIngrediente: int",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEsM6TzVDAo=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzyothk="
											},
											"model": {
												"$ref": "AAAAAAGTmEsM4zzSZc0="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1637,
											"top": 522,
											"width": 200.80517578125,
											"height": 13,
											"text": "-nombre: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGTmEs1HTzdVhs=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzyothk="
											},
											"model": {
												"$ref": "AAAAAAGTmEs1FjzazEs="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1637,
											"top": 537,
											"width": 200.80517578125,
											"height": 13,
											"text": "-descripcion: String",
											"horizontalAlignment": 0
										},
										{
											"_type": "UMLAttributeView",
											"_id": "AAAAAAGVAL366wUOd+8=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzyothk="
											},
											"model": {
												"$ref": "AAAAAAGVAL363gULz2I="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1637,
											"top": 552,
											"width": 200.80517578125,
											"height": 13,
											"text": "+proveedor: ArrayList<Proveedor>",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1632,
									"top": 502,
									"width": 210.80517578125,
									"height": 68
								},
								{
									"_type": "UMLOperationCompartmentView",
									"_id": "AAAAAAGTmErYAzypOsE=",
									"_parent": {
										"$ref": "AAAAAAGTmErYAzyi9CQ="
									},
									"model": {
										"$ref": "AAAAAAGTmErYAzygzHM="
									},
									"subViews": [
										{
											"_type": "UMLOperationView",
											"_id": "AAAAAAGTmF9Wrj7c2EU=",
											"_parent": {
												"$ref": "AAAAAAGTmErYAzypOsE="
											},
											"model": {
												"$ref": "AAAAAAGTmF9Wpj7ZAOU="
											},
											"font": "Arial;13;0",
											"parentStyle": true,
											"left": 1637,
											"top": 575,
											"width": 200.80517578125,
											"height": 13,
											"text": "+mostrarInfo(): String",
											"horizontalAlignment": 0
										}
									],
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": 1632,
									"top": 570,
									"width": 210.80517578125,
									"height": 23
								},
								{
									"_type": "UMLReceptionCompartmentView",
									"_id": "AAAAAAGTmErYBDyqdQg=",
									"_parent": {
										"$ref": "AAAAAAGTmErYAzyi9CQ="
									},
									"model": {
										"$ref": "AAAAAAGTmErYAzygzHM="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -1619.507568359375,
									"top": 600,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLTemplateParameterCompartmentView",
									"_id": "AAAAAAGTmErYBDyrn+Y=",
									"_parent": {
										"$ref": "AAAAAAGTmErYAzyi9CQ="
									},
									"model": {
										"$ref": "AAAAAAGTmErYAzygzHM="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -1619.507568359375,
									"top": 600,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"containerChangeable": true,
							"left": 1632,
							"top": 477,
							"width": 209.80517578125,
							"height": 116,
							"nameCompartment": {
								"$ref": "AAAAAAGTmErYAzyjFXg="
							},
							"attributeCompartment": {
								"$ref": "AAAAAAGTmErYAzyothk="
							},
							"operationCompartment": {
								"$ref": "AAAAAAGTmErYAzypOsE="
							},
							"receptionCompartment": {
								"$ref": "AAAAAAGTmErYBDyqdQg="
							},
							"templateParameterCompartment": {
								"$ref": "AAAAAAGTmErYBDyrn+Y="
							}
						},
						{
							"_type": "UMLGeneralizationView",
							"_id": "AAAAAAGTmEyPbTzqhZo=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEyPbTzoGt8="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEyPbTzr2VA=",
									"_parent": {
										"$ref": "AAAAAAGTmEyPbTzqhZo="
									},
									"model": {
										"$ref": "AAAAAAGTmEyPbTzoGt8="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1145,
									"top": 675,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEyPbTzqhZo="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEyPbTzsMJY=",
									"_parent": {
										"$ref": "AAAAAAGTmEyPbTzqhZo="
									},
									"model": {
										"$ref": "AAAAAAGTmEyPbTzoGt8="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1138,
									"top": 688,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGTmEyPbTzqhZo="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEyPbTzt3DA=",
									"_parent": {
										"$ref": "AAAAAAGTmEyPbTzqhZo="
									},
									"model": {
										"$ref": "AAAAAAGTmEyPbTzoGt8="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1158,
									"top": 648,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEyPbTzqhZo="
									},
									"edgePosition": 1
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl7ozsTkdb9k="
							},
							"tail": {
								"$ref": "AAAAAAGTmEmwODv6KnE="
							},
							"lineStyle": 3,
							"points": "1063:759;1152:668;1020:599",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGTmEyPbTzr2VA="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGTmEyPbTzsMJY="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGTmEyPbTzt3DA="
							}
						},
						{
							"_type": "UMLGeneralizationView",
							"_id": "AAAAAAGTmEyZNTz7kDE=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGTmEyZNTz5dzo="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEyZNTz8GLs=",
									"_parent": {
										"$ref": "AAAAAAGTmEyZNTz7kDE="
									},
									"model": {
										"$ref": "AAAAAAGTmEyZNTz5dzo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1383,
									"top": 676,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEyZNTz7kDE="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEyZNTz9D4w=",
									"_parent": {
										"$ref": "AAAAAAGTmEyZNTz7kDE="
									},
									"model": {
										"$ref": "AAAAAAGTmEyZNTz5dzo="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1379,
									"top": 690,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGTmEyZNTz7kDE="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGTmEyZNTz+67U=",
									"_parent": {
										"$ref": "AAAAAAGTmEyZNTz7kDE="
									},
									"model": {
										"$ref": "AAAAAAGTmEyZNTz5dzo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1390,
									"top": 647,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGTmEyZNTz7kDE="
									},
									"edgePosition": 1
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl7ozsTkdb9k="
							},
							"tail": {
								"$ref": "AAAAAAGTmEn9sjwyYYw="
							},
							"lineStyle": 3,
							"points": "1350:743;1387:668;1020:569",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGTmEyZNTz8GLs="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGTmEyZNTz9D4w="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGTmEyZNTz+67U="
							}
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVAChBcV3fer0=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVAChBcV3bJxY="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3gQBc=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3bJxY="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1249,
									"top": 594,
									"width": 71.1572265625,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"edgePosition": 1,
									"text": "+suministrar"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3hPU4=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3bJxY="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1269,
									"top": 594,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3iXeA=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3bJxY="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1313,
									"top": 595,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3j4fA=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3cp4Y="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1117,
									"top": 730,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.6899000676115516,
									"distance": 24.839484696748443,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"edgePosition": 2,
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3kEJw=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3cp4Y="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1133,
									"top": 714,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3lGaM=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3cp4Y="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1145,
									"top": 754,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3meLc=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3djJc="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1288,
									"top": 551,
									"width": 27.1044921875,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"text": "+1..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3nSiw=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3djJc="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1295,
									"top": 562,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAChBcV3oTOE=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3djJc="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1316,
									"top": 527,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVAChBcV3pdks=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3cp4Y="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVAChBcV3qY5Q=",
									"_parent": {
										"$ref": "AAAAAAGVAChBcV3fer0="
									},
									"model": {
										"$ref": "AAAAAAGVAChBcV3djJc="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTmEp7aDxo3ic="
							},
							"tail": {
								"$ref": "AAAAAAGTmEmwODv6KnE="
							},
							"lineStyle": 3,
							"points": "1121:759;1299:668;1299:535;1292:529",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVAChBcV3gQBc="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVAChBcV3hPU4="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVAChBcV3iXeA="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVAChBcV3j4fA="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVAChBcV3kEJw="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVAChBcV3lGaM="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVAChBcV3meLc="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVAChBcV3nSiw="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVAChBcV3oTOE="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVAChBcV3pdks="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVAChBcV3qY5Q="
							}
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVACsnSG8H9Xg=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVACsnR28DNXA="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8Im4U=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28DNXA="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1436,
									"top": 527,
									"width": 40.11083984375,
									"height": 13,
									"alpha": -6.084545278691233,
									"distance": 135.79396157414365,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"edgePosition": 1,
									"text": "+hacer"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8J3To=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28DNXA="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1445,
									"top": 660,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8KrpA=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28DNXA="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1489,
									"top": 662,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8LALk=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28EZ6k="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1389,
									"top": 708,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"edgePosition": 2,
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8M6So=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28EZ6k="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1395,
									"top": 697,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8NmUQ=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28EZ6k="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1418,
									"top": 731,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8Ot2w=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28Ffpo="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1464,
									"top": 368,
									"width": 27.1044921875,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"text": "+1..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8Pcsk=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28Ffpo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1464,
									"top": 369,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVACsnSG8QrYo=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28Ffpo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1505,
									"top": 365,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVACsnSG8RYiQ=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28EZ6k="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVACsnSG8S8Hs=",
									"_parent": {
										"$ref": "AAAAAAGVACsnSG8H9Xg="
									},
									"model": {
										"$ref": "AAAAAAGVACsnR28Ffpo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl73WdjpLCoI="
							},
							"tail": {
								"$ref": "AAAAAAGTmEn9sjwyYYw="
							},
							"lineStyle": 3,
							"points": "1394:743;1475:668;1494:349",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVACsnSG8Im4U="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVACsnSG8J3To="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVACsnSG8KrpA="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVACsnSG8LALk="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVACsnSG8M6So="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVACsnSG8NmUQ="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVACsnSG8Ot2w="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVACsnSG8Pcsk="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVACsnSG8QrYo="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVACsnSG8RYiQ="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVACsnSG8S8Hs="
							}
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVAC7UenyOJhI=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVAC7UeXyK7io="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenyPZeE=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyK7io="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1151,
									"top": 4,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenyQqFg=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyK7io="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1166,
									"top": 4,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenyR0BU=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyK7io="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1121,
									"top": 5,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenySPpQ=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyL3Wo="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 949,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"edgePosition": 2,
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenyTmK4=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyL3Wo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 948,
									"top": -3,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenyUSTs=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyL3Wo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 989,
									"top": 4,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenyVYao=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyM2ig="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1118,
									"top": 120,
									"width": 29.275390625,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"text": "+0..1"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenyWNzc=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyM2ig="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1135,
									"top": 134,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAC7UenyXFt0=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyM2ig="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1128,
									"top": 93,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVAC7UenyYhQc=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyL3Wo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -123.071533203125,
									"top": 204,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVAC7UenyZpAg=",
									"_parent": {
										"$ref": "AAAAAAGVAC7UenyOJhI="
									},
									"model": {
										"$ref": "AAAAAAGVAC7UeXyM2ig="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"left": -123.071533203125,
									"top": 204,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl7yPEjnyXNg="
							},
							"tail": {
								"$ref": "AAAAAAGTl7yPEjnyXNg="
							},
							"points": "977:32;977:11;1136:11;1136:112;1107:112",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVAC7UenyPZeE="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVAC7UenyQqFg="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVAC7UenyR0BU="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVAC7UenySPpQ="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVAC7UenyTmK4="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVAC7UenyUSTs="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVAC7UenyVYao="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVAC7UenyWNzc="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVAC7UenyXFt0="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVAC7UenyYhQc="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVAC7UenyZpAg="
							}
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVAC9rSIiU49U=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 1144,
							"top": 40,
							"width": 100,
							"height": 25,
							"text": "supervisar"
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVADM04JJE8go=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVADM035JAWqw="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJFiso=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM035JAWqw="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 138,
									"top": 397,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJGOt4=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM035JAWqw="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 123,
									"top": 398,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJHc5w=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM035JAWqw="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 167,
									"top": 394,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJI9DA=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM035JBnfg="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 278,
									"top": 474,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"edgePosition": 2,
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJJ+8s=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM035JBnfg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 283,
									"top": 485,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJKWYo=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM035JBnfg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 306,
									"top": 450,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJLgn8=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM04JJCMzs="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 128,
									"top": 366,
									"width": 14.82177734375,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"text": "+1"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJMX6A=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM04JJCMzs="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 122,
									"top": 369,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADM04JJN5iY=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM04JJCMzs="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 162,
									"top": 359,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVADM04JJE8go="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVADM04JJOHRw=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM035JBnfg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVADM04JJPCUo=",
									"_parent": {
										"$ref": "AAAAAAGVADM04JJE8go="
									},
									"model": {
										"$ref": "AAAAAAGVADM04JJCMzs="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl7uSsDloUbA="
							},
							"tail": {
								"$ref": "AAAAAAGTl76eUDrrCSU="
							},
							"lineStyle": 3,
							"points": "321:477;153:402;148:345",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVADM04JJFiso="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVADM04JJGOt4="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVADM04JJHc5w="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVADM04JJI9DA="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVADM04JJJ+8s="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVADM04JJKWYo="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVADM04JJLgn8="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVADM04JJMX6A="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVADM04JJN5iY="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVADM04JJOHRw="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVADM04JJPCUo="
							}
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVADSA0Je8CDg=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVADSA0Je4LxM="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0Je9B68=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je4LxM="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 497,
									"top": 395,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0Ze+aWg=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je4LxM="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 482,
									"top": 395,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0Ze/AgE=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je4LxM="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 526,
									"top": 396,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0ZfA0jQ=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je5QSo="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 490,
									"top": 380,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"edgePosition": 2,
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0ZfBskI=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je5QSo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 492,
									"top": 372,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0ZfC5/U=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je5QSo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 525,
									"top": 396,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0ZfD9lE=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je62II="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 483,
									"top": 352,
									"width": 29.275390625,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"text": "+0..1"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0ZfE0Js=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je62II="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 483,
									"top": 355,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSA0ZfFRDw=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je62II="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 524,
									"top": 348,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVADSA0ZfG5bo=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je5QSo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVADSA0ZfHiJw=",
									"_parent": {
										"$ref": "AAAAAAGVADSA0Je8CDg="
									},
									"model": {
										"$ref": "AAAAAAGVADSA0Je62II="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl75cjzq4M1M="
							},
							"tail": {
								"$ref": "AAAAAAGTl76eUDrrCSU="
							},
							"lineStyle": 3,
							"points": "505:416;512:402;512:333",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVADSA0Je9B68="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVADSA0Ze+aWg="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVADSA0Ze/AgE="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVADSA0ZfA0jQ="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVADSA0ZfBskI="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVADSA0ZfC5/U="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVADSA0ZfD9lE="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVADSA0ZfE0Js="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVADSA0ZfFRDw="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVADSA0ZfG5bo="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVADSA0ZfHiJw="
							}
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVADSIzJo5EDw=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVADSIzJo1X+8="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJo6+Ww=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo1X+8="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 901,
									"top": 385,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJo7KAQ=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo1X+8="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 891,
									"top": 374,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJo8Rvk=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo1X+8="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 922,
									"top": 406,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJo9phQ=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo25IY="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 587,
									"top": 470,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"edgePosition": 2,
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJo+W/4=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo25IY="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 599,
									"top": 456,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJo/XIE=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo25IY="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 604,
									"top": 497,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJpAuaQ=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo3V7U="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 890,
									"top": 388,
									"width": 14.82177734375,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"text": "+1"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJpBfIE=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo3V7U="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 887,
									"top": 380,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADSIzJpC21A=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo3V7U="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 919,
									"top": 405,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVADSIzJpDnsE=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo25IY="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVADSIzJpExhA=",
									"_parent": {
										"$ref": "AAAAAAGVADSIzJo5EDw="
									},
									"model": {
										"$ref": "AAAAAAGVADSIzJo3V7U="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl74dmjqGVG0="
							},
							"tail": {
								"$ref": "AAAAAAGTl76eUDrrCSU="
							},
							"lineStyle": 3,
							"points": "580:498;912:402;927:388",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVADSIzJo6+Ww="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVADSIzJo7KAQ="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVADSIzJo8Rvk="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVADSIzJo9phQ="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVADSIzJo+W/4="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVADSIzJo/XIE="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVADSIzJpAuaQ="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVADSIzJpBfIE="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVADSIzJpC21A="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVADSIzJpDnsE="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVADSIzJpExhA="
							}
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVADWstLiQZzg=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVADWstLiMrdM="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiRGV4=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiMrdM="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1002,
									"top": 671,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiS+HM=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiMrdM="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 991,
									"top": 681,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiT3oU=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiMrdM="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1025,
									"top": 652,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiUKF8=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiNlQc="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 705,
									"top": 760,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"edgePosition": 2,
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiVgzQ=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiNlQc="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 716,
									"top": 747,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiWoNE=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiNlQc="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 724,
									"top": 787,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiXMR8=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiOLNo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 970,
									"top": 634,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiYcTw=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiOLNo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 961,
									"top": 644,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVADWstLiZWYU=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiOLNo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 988,
									"top": 613,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVADWstLiaHcI=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiNlQc="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVADWstLibViM=",
									"_parent": {
										"$ref": "AAAAAAGVADWstLiQZzg="
									},
									"model": {
										"$ref": "AAAAAAGVADWstLiOLNo="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl7ozsTkdb9k="
							},
							"tail": {
								"$ref": "AAAAAAGTmEaGoTtVwAo="
							},
							"lineStyle": 3,
							"points": "700:790;1014:668;965:611",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVADWstLiRGV4="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVADWstLiS+HM="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVADWstLiT3oU="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVADWstLiUKF8="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVADWstLiVgzQ="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVADWstLiWoNE="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVADWstLiXMR8="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVADWstLiYcTw="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVADWstLiZWYU="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVADWstLiaHcI="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVADWstLibViM="
							}
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVADclR9rCF/Q=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 1229.461181640625,
							"top": 88,
							"width": 100,
							"height": 25
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVAL5cyAm72UE=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVAL5cyAm32Qg="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAm8rZE=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm32Qg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1730,
									"top": 410,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAm9J6Q=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm32Qg="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1732,
									"top": 425,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAm+HdY=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm32Qg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1725,
									"top": 381,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAm/hrA=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm4XEA="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1702,
									"top": 444,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"edgePosition": 2,
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAnA6zw=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm4XEA="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1702,
									"top": 443,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAnBNYU=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm4XEA="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1743,
									"top": 447,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAnCaYI=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm5Uyg="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1394,
									"top": 458,
									"width": 27.1044921875,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"text": "+1..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAnDzQ8=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm5Uyg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1412,
									"top": 471,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVAL5cyAnE8cA=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm5Uyg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1399,
									"top": 432,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVAL5cyAnF5nE=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm4XEA="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVAL5cyAnGuOA=",
									"_parent": {
										"$ref": "AAAAAAGVAL5cyAm72UE="
									},
									"model": {
										"$ref": "AAAAAAGVAL5cyAm5Uyg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTmEp7aDxo3ic="
							},
							"tail": {
								"$ref": "AAAAAAGTmErYAzyi9CQ="
							},
							"lineStyle": 3,
							"points": "1732:476;1728:402;1380:454",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVAL5cyAm8rZE="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVAL5cyAm9J6Q="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVAL5cyAm+HdY="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVAL5cyAm/hrA="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVAL5cyAnA6zw="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVAL5cyAnBNYU="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVAL5cyAnCaYI="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVAL5cyAnDzQ8="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVAL5cyAnE8cA="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVAL5cyAnF5nE="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVAL5cyAnGuOA="
							}
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVAMGVPmyJplI=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 1536,
							"top": 408,
							"width": 100,
							"height": 25,
							"text": "vender"
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVAMKJtIAFFJE=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 753,
							"top": 442,
							"width": 100,
							"height": 25,
							"text": "gestionar"
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVAMMT0o5Daao=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 512,
							"top": 344,
							"width": 100,
							"height": 25,
							"text": "repartir"
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVAMN+G5y62jk=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 200,
							"top": 432,
							"width": 100,
							"height": 25,
							"text": "tener"
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVAMOetaHq/eo=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 175,
							"top": 401,
							"width": 100,
							"height": 25
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVAMRk3MyLwR0=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 870,
							"top": 712,
							"width": 100,
							"height": 25,
							"text": "incluir"
						},
						{
							"_type": "UMLTextView",
							"_id": "AAAAAAGVAMR3Y89B2Ys=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"font": "Arial;13;0",
							"parentStyle": false,
							"left": 1008,
							"top": 620,
							"width": 100,
							"height": 25,
							"text": "1"
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVANR8giXH8k4=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVANR8giXD2yA="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXI7bY=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXD2yA="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1520,
									"top": 656,
									"width": 58.1826171875,
									"height": 13,
									"alpha": 2.9797863908851108,
									"distance": 14.317821063276353,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"edgePosition": 1,
									"text": "+contener"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXJ5NY=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXD2yA="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1552,
									"top": 686,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXKDW0=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXD2yA="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1527,
									"top": 649,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXLHpk=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXEqHg="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1621,
									"top": 614,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"edgePosition": 2,
									"text": "+1..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXMq94=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXEqHg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1640,
									"top": 627,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXNku4=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXEqHg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1623,
									"top": 589,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXOEbs=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXF9HU="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1441,
									"top": 735,
									"width": 27.1044921875,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"text": "+0..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXPpyg=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXF9HU="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1464,
									"top": 744,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANR8giXQJ/A=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXF9HU="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 1436,
									"top": 714,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVANR8giXRfc0=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXEqHg="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVANR8giXSzS8=",
									"_parent": {
										"$ref": "AAAAAAGVANR8giXH8k4="
									},
									"model": {
										"$ref": "AAAAAAGVANR8giXF9HU="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTmEn9sjwyYYw="
							},
							"tail": {
								"$ref": "AAAAAAGTmErYAzyi9CQ="
							},
							"lineStyle": 1,
							"points": "1648:594;1425:743",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVANR8giXI7bY="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVANR8giXJ5NY="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVANR8giXKDW0="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVANR8giXLHpk="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVANR8giXMq94="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVANR8giXNku4="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVANR8giXOEbs="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVANR8giXPpyg="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVANR8giXQJ/A="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVANR8giXRfc0="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVANR8giXSzS8="
							}
						},
						{
							"_type": "UMLAssociationView",
							"_id": "AAAAAAGVANUv9zldtTA=",
							"_parent": {
								"$ref": "AAAAAAFF+qBtyKM79qY="
							},
							"model": {
								"$ref": "AAAAAAGVANUv9zlZJ+U="
							},
							"subViews": [
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv9zle+O8=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zlZJ+U="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 464,
									"top": 716,
									"width": 58.1826171875,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"edgePosition": 1,
									"text": "+contener"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv9zlfC44=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zlZJ+U="
									},
									"visible": null,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 479,
									"top": 720,
									"height": 13,
									"alpha": 1.5707963267948966,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv9zlghoY=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zlZJ+U="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 522,
									"top": 707,
									"height": 13,
									"alpha": -1.5707963267948966,
									"distance": 15,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"edgePosition": 1
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv9zlhNgQ=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zla7l4="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 492,
									"top": 756,
									"width": 27.1044921875,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"edgePosition": 2,
									"text": "+1..*"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv9zli+UM=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zla7l4="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 492,
									"top": 758,
									"height": 13,
									"alpha": 0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv9zljRHw=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zla7l4="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 533,
									"top": 752,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"edgePosition": 2
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv9zlkNb8=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zlbXnI="
									},
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 474,
									"top": 677,
									"width": 14.82177734375,
									"height": 13,
									"alpha": -0.5235987755982988,
									"distance": 30,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"text": "+1"
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv9zll8Mo=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zlbXnI="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 469,
									"top": 683,
									"height": 13,
									"alpha": -0.7853981633974483,
									"distance": 40,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									}
								},
								{
									"_type": "EdgeLabelView",
									"_id": "AAAAAAGVANUv+DlmddM=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zlbXnI="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": false,
									"left": 506,
									"top": 664,
									"height": 13,
									"alpha": 0.5235987755982988,
									"distance": 25,
									"hostEdge": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									}
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVANUv+Dln200=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zla7l4="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								},
								{
									"_type": "UMLQualifierCompartmentView",
									"_id": "AAAAAAGVANUv+DloZQg=",
									"_parent": {
										"$ref": "AAAAAAGVANUv9zldtTA="
									},
									"model": {
										"$ref": "AAAAAAGVANUv9zlbXnI="
									},
									"visible": false,
									"font": "Arial;13;0",
									"parentStyle": true,
									"width": 10,
									"height": 10
								}
							],
							"font": "Arial;13;0",
							"parentStyle": false,
							"head": {
								"$ref": "AAAAAAGTl76eUDrrCSU="
							},
							"tail": {
								"$ref": "AAAAAAGTmEaGoTtVwAo="
							},
							"lineStyle": 1,
							"points": "528:783;488:654",
							"showVisibility": true,
							"nameLabel": {
								"$ref": "AAAAAAGVANUv9zle+O8="
							},
							"stereotypeLabel": {
								"$ref": "AAAAAAGVANUv9zlfC44="
							},
							"propertyLabel": {
								"$ref": "AAAAAAGVANUv9zlghoY="
							},
							"showEndOrder": "hide",
							"tailRoleNameLabel": {
								"$ref": "AAAAAAGVANUv9zlhNgQ="
							},
							"tailPropertyLabel": {
								"$ref": "AAAAAAGVANUv9zli+UM="
							},
							"tailMultiplicityLabel": {
								"$ref": "AAAAAAGVANUv9zljRHw="
							},
							"headRoleNameLabel": {
								"$ref": "AAAAAAGVANUv9zlkNb8="
							},
							"headPropertyLabel": {
								"$ref": "AAAAAAGVANUv9zll8Mo="
							},
							"headMultiplicityLabel": {
								"$ref": "AAAAAAGVANUv+DlmddM="
							},
							"tailQualifiersCompartment": {
								"$ref": "AAAAAAGVANUv+Dln200="
							},
							"headQualifiersCompartment": {
								"$ref": "AAAAAAGVANUv+DloZQg="
							}
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTl7ozsTkbeEA=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Producto",
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7pxKTlFs+E=",
							"_parent": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							},
							"name": "codigo",
							"visibility": "private",
							"type": "int"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7quYTlMMdk=",
							"_parent": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							},
							"name": "nombre",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7sDqjlTAkI=",
							"_parent": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							},
							"name": "tipo",
							"visibility": "private",
							"type": "enum"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7tXGDlem+c=",
							"_parent": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							},
							"name": "precio",
							"visibility": "private",
							"type": "double"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFl7fj3xe4A=",
							"_parent": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							},
							"name": "calcularImpuesto",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFm28j349pI=",
									"_parent": {
										"$ref": "AAAAAAGTmFl7fj3xe4A="
									},
									"type": "double",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFnWxz37xBE=",
							"_parent": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							},
							"name": "aplicarDescuento",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFrRwT4Ck8Y=",
									"_parent": {
										"$ref": "AAAAAAGTmFnWxz37xBE="
									},
									"name": "descuento",
									"type": "Double"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFrl0z4EP50=",
							"_parent": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							},
							"name": "mostrarInfo",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFrwFz4LAO4=",
									"_parent": {
										"$ref": "AAAAAAGTmFrl0z4EP50="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					],
					"isAbstract": true
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTl7uSsDlmvSs=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Cliente",
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7uijzmQbLA=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "idCliente",
							"visibility": "private",
							"type": "int"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7uyrjmXeJg=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "direccion",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7vLhjmezUQ=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "nombre",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7vfcDmlggw=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "apellido1",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7v13Tms894=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "apellido2",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGVACzQaXc079o=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "telefonos",
							"type": "ArrayList<String>"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFLBCj0bZhk=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "registrarCompra",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFt+Jj4Z0OE=",
									"_parent": {
										"$ref": "AAAAAAGTmFLBCj0bZhk="
									},
									"name": "compra",
									"type": {
										"$ref": "AAAAAAGTl76eUDrpj1I="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFs4Sz4O2B8=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "actualizarDireccion",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFtRYT4VX9U=",
									"_parent": {
										"$ref": "AAAAAAGTmFs4Sz4O2B8="
									},
									"name": "nuevaDireccion",
									"type": "String"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFuaFj4bqnU=",
							"_parent": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							},
							"name": "obtenerNombreCompleto",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFugKz4i5oo=",
									"_parent": {
										"$ref": "AAAAAAGTmFuaFj4bqnU="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTl7w5wDm41VA=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Telefono",
					"ownedElements": [
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGTmFNmTj0jQto=",
							"_parent": {
								"$ref": "AAAAAAGTl7w5wDm41VA="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGTmFNmTj0kcI0=",
								"_parent": {
									"$ref": "AAAAAAGTmFNmTj0jQto="
								},
								"reference": {
									"$ref": "AAAAAAGTl7w5wDm41VA="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGTmFNmTj0l6w4=",
								"_parent": {
									"$ref": "AAAAAAGTmFNmTj0jQto="
								},
								"reference": {
									"$ref": "AAAAAAGTl7uSsDlmvSs="
								}
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7xLnTniOkY=",
							"_parent": {
								"$ref": "AAAAAAGTl7w5wDm41VA="
							},
							"name": "numTelefono",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7x3vznpUP0=",
							"_parent": {
								"$ref": "AAAAAAGTl7w5wDm41VA="
							},
							"name": "idCliente",
							"visibility": "private",
							"type": "int"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFxSET4ue7I=",
							"_parent": {
								"$ref": "AAAAAAGTl7w5wDm41VA="
							},
							"name": "asociarCliente",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFxYcT41YdE=",
									"_parent": {
										"$ref": "AAAAAAGTmFxSET4ue7I="
									},
									"name": "idCliente",
									"type": "String"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFxtGz43DsQ=",
							"_parent": {
								"$ref": "AAAAAAGTl7w5wDm41VA="
							},
							"name": "obtenerTelefono",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFxyLj4+X+E=",
									"_parent": {
										"$ref": "AAAAAAGTmFxtGz43DsQ="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTl7yPEjnwxTI=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Empleado",
					"ownedElements": [
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVAC7UeXyK7io=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVAC7UeXyL3Wo=",
								"_parent": {
									"$ref": "AAAAAAGVAC7UeXyK7io="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTl7yPEjnwxTI="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVAC7UeXyM2ig=",
								"_parent": {
									"$ref": "AAAAAAGVAC7UeXyK7io="
								},
								"name": "0..1",
								"reference": {
									"$ref": "AAAAAAGTl7yPEjnwxTI="
								},
								"navigable": "navigable"
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7y8wjogBaE=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"name": "dni",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl70zXTonQKo=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"name": "salario",
							"visibility": "private",
							"type": "double"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl71F/jouAB4=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"name": "fnac",
							"visibility": "private",
							"type": "LocalDate"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7125zo1rLc=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"name": "nombre",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl72Ogjo8z+Y=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"name": "encargado",
							"visibility": "private",
							"type": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							}
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFzRqT5D5jY=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"name": "calcularEdad",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFzbCT5KQ5g=",
									"_parent": {
										"$ref": "AAAAAAGTmFzRqT5D5jY="
									},
									"type": "int",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFzl8z5Mxnk=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"name": "asignarEncargado",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFzuuj5TKw8=",
									"_parent": {
										"$ref": "AAAAAAGTmFzl8z5Mxnk="
									},
									"name": "encargado",
									"type": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFz3WD5VK3I=",
							"_parent": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							},
							"name": "mostrarInfo",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFz7mT5cQ2s=",
									"_parent": {
										"$ref": "AAAAAAGTmFz3WD5VK3I="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					],
					"isAbstract": true
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTl73WdjpJ5RU=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Panadero",
					"ownedElements": [
						{
							"_type": "UMLGeneralization",
							"_id": "AAAAAAGTmEe0fzug430=",
							"_parent": {
								"$ref": "AAAAAAGTl73WdjpJ5RU="
							},
							"source": {
								"$ref": "AAAAAAGTl73WdjpJ5RU="
							},
							"target": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl73kRzpzlFs=",
							"_parent": {
								"$ref": "AAAAAAGTl73WdjpJ5RU="
							},
							"name": "dni",
							"visibility": "private",
							"type": "String"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF0oCT5fHhQ=",
							"_parent": {
								"$ref": "AAAAAAGTl73WdjpJ5RU="
							},
							"name": "prepararProducto",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF0tEj5mZcc=",
									"_parent": {
										"$ref": "AAAAAAGTmF0oCT5fHhQ="
									},
									"name": "producto",
									"type": {
										"$ref": "AAAAAAGTmEn9sjwwr+I="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMmcjAhZv2A=",
							"_parent": {
								"$ref": "AAAAAAGTl73WdjpJ5RU="
							},
							"name": "calcularEdad",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMmg7QluaR8=",
									"_parent": {
										"$ref": "AAAAAAGVAMmcjAhZv2A="
									},
									"type": "int",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMnkxh3R6Sc=",
							"_parent": {
								"$ref": "AAAAAAGTl73WdjpJ5RU="
							},
							"name": "asignarEncargado",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMnn/h7mJhk=",
									"_parent": {
										"$ref": "AAAAAAGVAMnkxh3R6Sc="
									},
									"name": "encargado",
									"type": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMuvE4x4AGo=",
							"_parent": {
								"$ref": "AAAAAAGTl73WdjpJ5RU="
							},
							"name": "mostrarInfo",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMu0EI2N5HA=",
									"_parent": {
										"$ref": "AAAAAAGVAMuvE4x4AGo="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTl74dmjqEkd4=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Dependiente",
					"ownedElements": [
						{
							"_type": "UMLGeneralization",
							"_id": "AAAAAAGTmEfLcjvCyUg=",
							"_parent": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"source": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"target": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl75A9Dquhl4=",
							"_parent": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"name": "dni",
							"visibility": "private",
							"type": "String"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF1lIz5vtI0=",
							"_parent": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"name": "atenderCliente",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF1p3D52Jpg=",
									"_parent": {
										"$ref": "AAAAAAGTmF1lIz5vtI0="
									},
									"name": "cliente",
									"type": {
										"$ref": "AAAAAAGTl7uSsDlmvSs="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF2lSj58HrI=",
							"_parent": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"name": "aplicarDescuento",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF2prD6D5/0=",
									"_parent": {
										"$ref": "AAAAAAGTmF2lSj58HrI="
									},
									"name": "compra",
									"type": {
										"$ref": "AAAAAAGTl76eUDrpj1I="
									}
								},
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF2prT6E4N8=",
									"_parent": {
										"$ref": "AAAAAAGTmF2lSj58HrI="
									},
									"name": "descuento",
									"type": "Double"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMl6CQBP+Ko=",
							"_parent": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"name": "calcularEdad",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMl+JgGCGf4=",
									"_parent": {
										"$ref": "AAAAAAGVAMl6CQBP+Ko="
									},
									"type": "int",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMnBYhNRW3M=",
							"_parent": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"name": "asignarEncargado",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMnHPxSi08g=",
									"_parent": {
										"$ref": "AAAAAAGVAMnBYhNRW3M="
									},
									"name": "encargado",
									"type": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMtKKX7FcWc=",
							"_parent": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							},
							"name": "mostrarInfo",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMtOXX/4V/4=",
									"_parent": {
										"$ref": "AAAAAAGVAMtKKX7FcWc="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTl75cjzq2BZM=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Repartidor",
					"ownedElements": [
						{
							"_type": "UMLGeneralization",
							"_id": "AAAAAAGTmEfBFDuxxOk=",
							"_parent": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							},
							"source": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							},
							"target": {
								"$ref": "AAAAAAGTl7yPEjnwxTI="
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7585jrhnKA=",
							"_parent": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							},
							"name": "dni",
							"visibility": "private",
							"type": "String"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF31UT6Mvg4=",
							"_parent": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							},
							"name": "realizarEntrega",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF36Az6T+vM=",
									"_parent": {
										"$ref": "AAAAAAGTmF31UT6Mvg4="
									},
									"name": "compra",
									"type": {
										"$ref": "AAAAAAGTl76eUDrpj1I="
									}
								},
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF36Az6ULQY=",
									"_parent": {
										"$ref": "AAAAAAGTmF31UT6Mvg4="
									},
									"name": "fecha",
									"type": "LocalDate"
								},
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF36Az6VlPY=",
									"_parent": {
										"$ref": "AAAAAAGTmF31UT6Mvg4="
									},
									"name": "hora",
									"type": "String"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMlw+f12pS8=",
							"_parent": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							},
							"name": "calcularEdad",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMl1/P6pu+4=",
									"_parent": {
										"$ref": "AAAAAAGVAMlw+f12pS8="
									},
									"type": "int",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMm30BB4kOk=",
							"_parent": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							},
							"name": "asignarEncargado",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMm80hGr1W8=",
									"_parent": {
										"$ref": "AAAAAAGVAMm30BB4kOk="
									},
									"name": "encargado",
									"type": {
										"$ref": "AAAAAAGTl7yPEjnwxTI="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAMs+n3vsd8E=",
							"_parent": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							},
							"name": "mostrarInfo",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAMtGPn0fSMo=",
									"_parent": {
										"$ref": "AAAAAAGVAMs+n3vsd8E="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTl76eUDrpj1I=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Compra",
					"ownedElements": [
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVADM035JAWqw=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADM035JBnfg=",
								"_parent": {
									"$ref": "AAAAAAGVADM035JAWqw="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTl76eUDrpj1I="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADM04JJCMzs=",
								"_parent": {
									"$ref": "AAAAAAGVADM035JAWqw="
								},
								"name": "1",
								"reference": {
									"$ref": "AAAAAAGTl7uSsDlmvSs="
								},
								"navigable": "navigable"
							}
						},
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVADSA0Je4LxM=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADSA0Je5QSo=",
								"_parent": {
									"$ref": "AAAAAAGVADSA0Je4LxM="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTl76eUDrpj1I="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADSA0Je62II=",
								"_parent": {
									"$ref": "AAAAAAGVADSA0Je4LxM="
								},
								"name": "0..1",
								"reference": {
									"$ref": "AAAAAAGTl75cjzq2BZM="
								},
								"navigable": "navigable"
							}
						},
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVADSIzJo1X+8=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADSIzJo25IY=",
								"_parent": {
									"$ref": "AAAAAAGVADSIzJo1X+8="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTl76eUDrpj1I="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADSIzJo3V7U=",
								"_parent": {
									"$ref": "AAAAAAGVADSIzJo1X+8="
								},
								"name": "1",
								"reference": {
									"$ref": "AAAAAAGTl74dmjqEkd4="
								},
								"navigable": "navigable"
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl76pgDsT5nQ=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "numCompra",
							"visibility": "private",
							"type": "int"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl77U/jsbnrs=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "fecha",
							"visibility": "private",
							"type": "LocalDate"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl77szTsiNcE=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "cliente",
							"visibility": "private",
							"type": {
								"$ref": "AAAAAAGTl7uSsDlmvSs="
							}
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl78EUTspCeA=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "dependiente",
							"visibility": "private",
							"type": {
								"$ref": "AAAAAAGTl74dmjqEkd4="
							}
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl78a+zswLX0=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "descuentoDependiente",
							"visibility": "private",
							"type": "double"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl79T7zs3mgQ=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "fechaDependiente",
							"visibility": "private",
							"type": "LocalDate"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl79nVDs+wgs=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "repartidor",
							"visibility": "private",
							"type": {
								"$ref": "AAAAAAGTl75cjzq2BZM="
							}
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl79+VDtFfcM=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "fechaRepartidor",
							"visibility": "private",
							"type": "LocalDate"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTl7+brjtM3EI=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "horaRepartidor",
							"visibility": "private",
							"type": "LocalTime"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFW5CT3TFiE=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "registrarLinea",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF6Khj6n2vw=",
									"_parent": {
										"$ref": "AAAAAAGTmFW5CT3TFiE="
									},
									"name": "linea",
									"type": {
										"$ref": "AAAAAAGTmEaGoDtT2U8="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFZLUT3dHNU=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "calcularTotal",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF4/5z6bUXI=",
									"_parent": {
										"$ref": "AAAAAAGTmFZLUT3dHNU="
									},
									"type": "double",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF5PZj6dtHc=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "asociarCliente",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF5VmD6kfns=",
									"_parent": {
										"$ref": "AAAAAAGTmF5PZj6dtHc="
									},
									"name": "cliente",
									"type": {
										"$ref": "AAAAAAGTl7uSsDlmvSs="
									}
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTu7uOKjBDGTM=",
							"_parent": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							},
							"name": "generarFactura",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTu71JJTBWMW4=",
									"_parent": {
										"$ref": "AAAAAAGTu7uOKjBDGTM="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTmEaGoDtT2U8=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Linea_De_Ticket",
					"ownedElements": [
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVADWkNbVPisY=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"name": "1",
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADWkNbVQpTs=",
								"_parent": {
									"$ref": "AAAAAAGVADWkNbVPisY="
								},
								"name": "1..*",
								"reference": {
									"$ref": "AAAAAAGTmEaGoDtT2U8="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADWkNbVRmEc=",
								"_parent": {
									"$ref": "AAAAAAGVADWkNbVPisY="
								},
								"reference": {
									"$ref": "AAAAAAGTl76eUDrpj1I="
								},
								"navigable": "navigable"
							}
						},
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVADWstLiMrdM=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADWstLiNlQc=",
								"_parent": {
									"$ref": "AAAAAAGVADWstLiMrdM="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTmEaGoDtT2U8="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVADWstLiOLNo=",
								"_parent": {
									"$ref": "AAAAAAGVADWstLiMrdM="
								},
								"reference": {
									"$ref": "AAAAAAGTl7ozsTkbeEA="
								},
								"navigable": "navigable"
							}
						},
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVANUv9zlZJ+U=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"name": "contener",
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVANUv9zla7l4=",
								"_parent": {
									"$ref": "AAAAAAGVANUv9zlZJ+U="
								},
								"name": "1..*",
								"reference": {
									"$ref": "AAAAAAGTmEaGoDtT2U8="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVANUv9zlbXnI=",
								"_parent": {
									"$ref": "AAAAAAGVANUv9zlZJ+U="
								},
								"name": "1",
								"reference": {
									"$ref": "AAAAAAGTl76eUDrpj1I="
								},
								"aggregation": "composite"
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEauJDt9l2M=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"name": "compra",
							"visibility": "private",
							"type": {
								"$ref": "AAAAAAGTl76eUDrpj1I="
							}
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEhn2DvUWgA=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"name": "numLinea",
							"visibility": "private",
							"type": "int"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEh/PjvbKWs=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"name": "producto",
							"visibility": "private",
							"type": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							}
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEjxWTviaHg=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"name": "cantidad",
							"visibility": "private",
							"type": "int"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmFSf7D2675M=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"name": "añadirProducto",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFVRhT3MY0s=",
									"_parent": {
										"$ref": "AAAAAAGTmFSf7D2675M="
									},
									"name": "int cantidad",
									"type": ""
								},
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmFVRhj3N2xI=",
									"_parent": {
										"$ref": "AAAAAAGTmFSf7D2675M="
									},
									"name": "String producto",
									"type": ""
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF6wZD6pHlk=",
							"_parent": {
								"$ref": "AAAAAAGTmEaGoDtT2U8="
							},
							"name": "calcularSubtotal",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF61oT6wXQY=",
									"_parent": {
										"$ref": "AAAAAAGTmF6wZD6pHlk="
									},
									"name": "producto",
									"type": {
										"$ref": "AAAAAAGTl7ozsTkbeEA="
									}
								},
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF61oT6xRL8=",
									"_parent": {
										"$ref": "AAAAAAGTmF6wZD6pHlk="
									},
									"type": "Double",
									"direction": "return"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTmEmwODv4Siw=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Ajeno",
					"ownedElements": [
						{
							"_type": "UMLGeneralization",
							"_id": "AAAAAAGTmEyPbTzoGt8=",
							"_parent": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"source": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"target": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							}
						},
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVAChBcV3bJxY=",
							"_parent": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"name": "suministrar",
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVAChBcV3cp4Y=",
								"_parent": {
									"$ref": "AAAAAAGVAChBcV3bJxY="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTmEmwODv4Siw="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVAChBcV3djJc=",
								"_parent": {
									"$ref": "AAAAAAGVAChBcV3bJxY="
								},
								"name": "1..*",
								"reference": {
									"$ref": "AAAAAAGTmEp7aDxmzMI="
								},
								"navigable": "navigable"
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEnBJjwih9k=",
							"_parent": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"name": "codigo",
							"visibility": "private",
							"type": "int"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGVACZvml0z3lw=",
							"_parent": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"name": "proveedor",
							"type": "ArrayList<Proveedor>"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF7RVT60a/Q=",
							"_parent": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"name": "mostrarInfo",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF7WHT67mfo=",
									"_parent": {
										"$ref": "AAAAAAGTmF7RVT60a/Q="
									},
									"type": "String",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAM3MD+g5f0I=",
							"_parent": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"name": "calcularImpuesto",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAM3PeelOSuc=",
									"_parent": {
										"$ref": "AAAAAAGVAM3MD+g5f0I="
									},
									"type": "double",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAM3ypPB/7gs=",
							"_parent": {
								"$ref": "AAAAAAGTmEmwODv4Siw="
							},
							"name": "aplicarDescuento",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAM31rPGyGHo=",
									"_parent": {
										"$ref": "AAAAAAGVAM3ypPB/7gs="
									},
									"name": "descuento",
									"type": "Double"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTmEn9sjwwr+I=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Propio",
					"ownedElements": [
						{
							"_type": "UMLGeneralization",
							"_id": "AAAAAAGTmEyZNTz5dzo=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"source": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"target": {
								"$ref": "AAAAAAGTl7ozsTkbeEA="
							}
						},
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVACsnR28DNXA=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"name": "hacer",
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVACsnR28EZ6k=",
								"_parent": {
									"$ref": "AAAAAAGVACsnR28DNXA="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTmEn9sjwwr+I="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVACsnR28Ffpo=",
								"_parent": {
									"$ref": "AAAAAAGVACsnR28DNXA="
								},
								"name": "1..*",
								"reference": {
									"$ref": "AAAAAAGTl73WdjpJ5RU="
								},
								"navigable": "navigable"
							}
						},
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVAL25HPlWAag=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVAL25HPlXRDg=",
								"_parent": {
									"$ref": "AAAAAAGVAL25HPlWAag="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTmEn9sjwwr+I="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVAL25HPlYGjc=",
								"_parent": {
									"$ref": "AAAAAAGVAL25HPlWAag="
								},
								"name": "1..*",
								"reference": {
									"$ref": "AAAAAAGTmErYAzygzHM="
								},
								"navigable": "navigable"
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEoL9jxaY8Q=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"name": "codigo",
							"visibility": "private",
							"type": "int"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGVACofzGNRGUA=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"name": "panadero",
							"type": "ArrayList<Panadero>"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGVADmyfPiScSU=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"name": "ingrediente",
							"type": "ArrayList<Ingrediente>"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGVALyFK+nXNUk=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"name": "cantidadIngrediente",
							"type": "ArrayList<Integer>"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF7ahD692qQ=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"name": "mostrarInfo",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF7eqD7ERlA=",
									"_parent": {
										"$ref": "AAAAAAGTmF7ahD692qQ="
									},
									"type": "String",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAM3W9+tOSas=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"name": "calcularImpuesto",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAM3bhOxjN+c=",
									"_parent": {
										"$ref": "AAAAAAGVAM3W9+tOSas="
									},
									"type": "double",
									"direction": "return"
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGVAM36BPNYirA=",
							"_parent": {
								"$ref": "AAAAAAGTmEn9sjwwr+I="
							},
							"name": "aplicarDescuento",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGVAM3+S/Rta3k=",
									"_parent": {
										"$ref": "AAAAAAGVAM36BPNYirA="
									},
									"name": "descuento",
									"type": "Double"
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTmEp7aDxmzMI=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Proveedor",
					"ownedElements": [
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVACcsFF0+G4Q=",
							"_parent": {
								"$ref": "AAAAAAGTmEp7aDxmzMI="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVACcsFF0/gjU=",
								"_parent": {
									"$ref": "AAAAAAGVACcsFF0+G4Q="
								},
								"reference": {
									"$ref": "AAAAAAGTmEp7aDxmzMI="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVACcsFF1AWww=",
								"_parent": {
									"$ref": "AAAAAAGVACcsFF0+G4Q="
								},
								"reference": {
									"$ref": "AAAAAAGTmEp7aDxmzMI="
								},
								"navigable": "navigable"
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEqMOzyQJBc=",
							"_parent": {
								"$ref": "AAAAAAGTmEp7aDxmzMI="
							},
							"name": "codProveedor",
							"visibility": "private",
							"type": "int"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEqr/TyYvys=",
							"_parent": {
								"$ref": "AAAAAAGTmEp7aDxmzMI="
							},
							"name": "nombre",
							"visibility": "private",
							"type": "String"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF8XdT7GAR8=",
							"_parent": {
								"$ref": "AAAAAAGTmEp7aDxmzMI="
							},
							"name": "registrarSuministro",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF8gqD7NX/E=",
									"_parent": {
										"$ref": "AAAAAAGTmF8XdT7GAR8="
									},
									"name": "Ajeno ajeno",
									"type": ""
								}
							]
						},
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF8rXT7P0mg=",
							"_parent": {
								"$ref": "AAAAAAGTmEp7aDxmzMI="
							},
							"name": "registrarVenta",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF8yAD7Wrjc=",
									"_parent": {
										"$ref": "AAAAAAGTmF8rXT7P0mg="
									},
									"name": "Ingrediente ingrediente",
									"type": ""
								}
							]
						}
					]
				},
				{
					"_type": "UMLClass",
					"_id": "AAAAAAGTmErYAzygzHM=",
					"_parent": {
						"$ref": "AAAAAAFF+qBWK6M3Z8Y="
					},
					"name": "Ingrediente",
					"ownedElements": [
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVAL5cyAm32Qg=",
							"_parent": {
								"$ref": "AAAAAAGTmErYAzygzHM="
							},
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVAL5cyAm4XEA=",
								"_parent": {
									"$ref": "AAAAAAGVAL5cyAm32Qg="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTmErYAzygzHM="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVAL5cyAm5Uyg=",
								"_parent": {
									"$ref": "AAAAAAGVAL5cyAm32Qg="
								},
								"name": "1..*",
								"reference": {
									"$ref": "AAAAAAGTmEp7aDxmzMI="
								},
								"navigable": "navigable"
							}
						},
						{
							"_type": "UMLAssociation",
							"_id": "AAAAAAGVANR8giXD2yA=",
							"_parent": {
								"$ref": "AAAAAAGTmErYAzygzHM="
							},
							"name": "contener",
							"end1": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVANR8giXEqHg=",
								"_parent": {
									"$ref": "AAAAAAGVANR8giXD2yA="
								},
								"name": "1..*",
								"reference": {
									"$ref": "AAAAAAGTmErYAzygzHM="
								}
							},
							"end2": {
								"_type": "UMLAssociationEnd",
								"_id": "AAAAAAGVANR8giXF9HU=",
								"_parent": {
									"$ref": "AAAAAAGVANR8giXD2yA="
								},
								"name": "0..*",
								"reference": {
									"$ref": "AAAAAAGTmEn9sjwwr+I="
								},
								"aggregation": "shared"
							}
						}
					],
					"attributes": [
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmErrDjzKrXk=",
							"_parent": {
								"$ref": "AAAAAAGTmErYAzygzHM="
							},
							"name": "codIngrediente",
							"visibility": "private",
							"type": "int"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEsM4zzSZc0=",
							"_parent": {
								"$ref": "AAAAAAGTmErYAzygzHM="
							},
							"name": "nombre",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGTmEs1FjzazEs=",
							"_parent": {
								"$ref": "AAAAAAGTmErYAzygzHM="
							},
							"name": "descripcion",
							"visibility": "private",
							"type": "String"
						},
						{
							"_type": "UMLAttribute",
							"_id": "AAAAAAGVAL363gULz2I=",
							"_parent": {
								"$ref": "AAAAAAGTmErYAzygzHM="
							},
							"name": "proveedor",
							"type": "ArrayList<Proveedor>"
						}
					],
					"operations": [
						{
							"_type": "UMLOperation",
							"_id": "AAAAAAGTmF9Wpj7ZAOU=",
							"_parent": {
								"$ref": "AAAAAAGTmErYAzygzHM="
							},
							"name": "mostrarInfo",
							"parameters": [
								{
									"_type": "UMLParameter",
									"_id": "AAAAAAGTmF9Z/z7gOCQ=",
									"_parent": {
										"$ref": "AAAAAAGTmF9Wpj7ZAOU="
									},
									"type": "String",
									"direction": "return"
								}
							]
						}
					]
				}
			]
		}
	]
}
